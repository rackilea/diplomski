import java.awt.EventQueue;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.activation.ActivationDataFlavor;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DragList {

    public static void main(String[] args) {
        new DragList();
    }

    public DragList() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultListModel<String> listModel = new DefaultListModel<>();
                listModel.addElement("Clara    Holmes");
                listModel.addElement("Bill    Moss");
                listModel.addElement("Della    Reeves");
                listModel.addElement("Lloyd    Gross");
                listModel.addElement("Cecilia    Floyd");
                listModel.addElement("Delia    Cummings");
                listModel.addElement("Tommy    Benson");
                listModel.addElement("Kirk    Casey");
                listModel.addElement("Chester    Manning");
                listModel.addElement("Elsa    Chapman");
                JList namesList = new JList(listModel);
                namesList.setDragEnabled(true);
                namesList.setDropMode(DropMode.ON_OR_INSERT);
                namesList.setTransferHandler(new ListItemTransferHandler());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(namesList));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ListItemTransferHandler extends TransferHandler {

        private DataFlavor flavor;

        public ListItemTransferHandler() {
            super("ListMove");
            flavor = new ActivationDataFlavor(int[].class, DataFlavor.javaJVMLocalObjectMimeType, "List of values");
        }

        @Override
        protected Transferable createTransferable(JComponent c) {

            System.out.println("createTransferable");
            JList list = (JList) c;
            DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
            int[] selectedValues = list.getSelectedIndices();

            List<ValuePair> values = new ArrayList<>(selectedValues.length);
            for (int index : selectedValues) {
                values.add(new ValuePair(index, model.getElementAt(index)));
            }

            return new ListOfValues(values);
        }

        @Override
        public boolean canImport(TransferSupport support) {
            boolean canImport = support.isDrop() && support.isDataFlavorSupported(flavor);
            return canImport;
        }

        @Override
        public int getSourceActions(JComponent c) {
            return MOVE;
        }

        @Override
        public boolean importData(TransferSupport support) {

            boolean imported = false;
            if (canImport(support)) {

                JList target = (JList) support.getComponent();
                target.clearSelection();
                JList.DropLocation dl = (JList.DropLocation) support.getDropLocation();
                DefaultListModel<String> model = (DefaultListModel<String>) target.getModel();
                int addIndex = dl.getIndex();
                if (addIndex < 0 || addIndex >= model.size()) {
                    addIndex = model.size();
                }

                try {
                    List<ValuePair> values = (List<ValuePair>) support.getTransferable().getTransferData(flavor);
                    for (ValuePair vp : values) {
                        int index = vp.getIndex();
                        String value = model.get(index);
                        model.add(addIndex, value);
                        target.addSelectionInterval(addIndex, addIndex);
                        addIndex++;
                    }
                    imported = true;
                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();
                }

            }

            return imported;

        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            if (action == MOVE) {

                JList list = (JList) source;
                DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
                try {

                    // Get the list of values and sort in decending order
                    List<ValuePair> values = (List<ValuePair>) data.getTransferData(flavor);
                    Collections.sort(values, new Comparator<ValuePair>() {
                        @Override
                        public int compare(ValuePair o1, ValuePair o2) {
                            return o2.getIndex() - o1.getIndex();
                        }
                    });

                    // Loop through for each item...
                    for (ValuePair vp : values) {

                        // Get the "last known" index of the value...
                        String modelValue = model.get(vp.getIndex());
                        String value = vp.getValue();
                        int index = vp.getIndex();

                        // If the value no long resides at it's last location, we need to find it,
                        // we can't rely on contains, as there are two values of the same value...
                        if (modelValue != value) {

                            // Look behind us, only the length of the number of values that were previously selected...
                            int startIndex = Math.max(vp.getIndex() - values.size(), 0);
                            int endIndex = vp.getIndex();
                            index = getIndexFor(value, model, startIndex, endIndex);
                            if (index < 0) {

                                // Look forward, only the length of the number of values that were previously selected...
                                endIndex = Math.min(vp.getIndex() + values.size(), model.size() - 1);
                                startIndex = vp.getIndex();
                                index = getIndexFor(value, model, startIndex, endIndex);

                            }

                        }

                        if (index < 0) {

                            // We lost the item ??
                            throw new IOException("Missing value?");

                        } else {

                            model.remove(index);

                        }

                    }

                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();
                }

            }
        }

        protected int getIndexFor(String value, DefaultListModel<String> model, int startIndex, int endIndex) {

            while (model.get(startIndex) != value && startIndex <= endIndex) {
                startIndex++;
            }

            return model.get(startIndex) == value ? startIndex : -1;

        }

        public class ValuePair {

            private int index;
            private String value;

            public ValuePair(int index, String value) {
                this.index = index;
                this.value = value;
            }

            public int getIndex() {
                return index;
            }

            public String getValue() {
                return value;
            }

        }

        public class ListOfValues implements Transferable {

            private List<ValuePair> values;

            public ListOfValues(List<ValuePair> values) {
                this.values = values;
            }

            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[]{flavor};
            }

            @Override
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                return Arrays.asList(getTransferDataFlavors()).contains(flavor);
            }

            @Override
            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                return values;
            }

        }

    }

}