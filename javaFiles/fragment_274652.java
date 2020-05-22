import java.awt.BorderLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.io.IOException;
import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;

public class Test {

    public static void main(String[] args) {
        createAndShowJFrame();
    }

    public static void createAndShowJFrame() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = createJFrame();
                frame.setVisible(true);

            }
        });
    }

    private static JFrame createJFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Test");

        JTable table = createJTable();
        JScrollPane js = new JScrollPane(table);

        frame.add(js, BorderLayout.CENTER);

        frame.add(createJLabelPanel(), BorderLayout.SOUTH);

        frame.pack();

        //frame.setResizable(false);//make it un-resizeable
        //frame.setLocationRelativeTo(null);//center JFrame

        return frame;
    }

    private static JTable createJTable() {
        // setup table data
        String[] columns = new String[]{"Foo", "Bar", "Baz", "Quux"};
        String[][] data = new String[][]{{"A", "B", "C", "D"},
            {"1", "2", "3", "4"},
            {"i", "ii", "iii", "iv"}};
        // create table
        final JTable table = new JTable(data, columns);

        // set up drag and drop
        table.setDragEnabled(true);
        table.setDropMode(DropMode.USE_SELECTION);
        table.setFillsViewportHeight(true);

        TransferHandler dnd = new TransferHandler() {
            @Override
            public boolean canImport(TransferSupport support) {
                if (!support.isDrop()) {
                    return false;
                }
                //only Strings
                if (!support.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean importData(TransferSupport support) {
                if (!canImport(support)) {
                    return false;
                }

                Transferable tansferable = support.getTransferable();
                String line;
                try {
                    line = (String) tansferable.getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }

                JTable.DropLocation dl = (JTable.DropLocation) support.getDropLocation();
                int column = dl.getColumn();
                int row = dl.getRow();

                String[] data = line.split(",");
                for (String item : data) {
                    if (!item.isEmpty()) {
                        table.getModel().setValueAt(item, row, column);
                    }
                }
                return true;
            }
        };
        table.setTransferHandler(dnd);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        return table;
    }

    private static JPanel createJLabelPanel() {
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Hello");
        JLabel label2 = new JLabel("Yay");
        JLabel label3 = new JLabel("Bye");

        MyDragGestureListener dlistener = new MyDragGestureListener();
        DragSource ds1 = new DragSource();
        ds1.createDefaultDragGestureRecognizer(label1, DnDConstants.ACTION_COPY, dlistener);

        DragSource ds2 = new DragSource();
        ds2.createDefaultDragGestureRecognizer(label2, DnDConstants.ACTION_COPY, dlistener);

        DragSource ds3 = new DragSource();
        ds3.createDefaultDragGestureRecognizer(label3, DnDConstants.ACTION_COPY, dlistener);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        return panel;
    }
}

class MyDragGestureListener implements DragGestureListener {

    @Override
    public void dragGestureRecognized(DragGestureEvent event) {
        JLabel label = (JLabel) event.getComponent();
        final String text = label.getText();


        Transferable transferable = new Transferable() {
            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[]{DataFlavor.stringFlavor};
            }

            @Override
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                if (!isDataFlavorSupported(flavor)) {
                    return false;
                }
                return true;
            }

            @Override
            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                return text;
            }
        };
        event.startDrag(null, transferable);
    }
}