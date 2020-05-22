import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import static javax.swing.Action.NAME;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TestTable100 {

    public static void main(String[] args) {
        new TestTable100();
    }

    public TestTable100() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Type");
                model.addColumn("Column");
                for (File file : new File(System.getProperty("user.home")).listFiles()) {
                    model.addRow(new Object[]{file, file});
                }

                JTable table = new JTable(model);
                table.getColumnModel().getColumn(0).setCellRenderer(new FirstCellRenderer());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                final JPopupMenu pm = new JPopupMenu();
                pm.add(new CopyAction(table));
                pm.add(new PasteAction(table));

                table.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (e.isPopupTrigger()) {
                            highlightRow(e);
                            doPopup(e);
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if (e.isPopupTrigger()) {
                            highlightRow(e);
                            doPopup(e);
                        }
                    }

                    protected void doPopup(MouseEvent e) {
                        pm.show(e.getComponent(), e.getX(), e.getY());
                    }

                    protected void highlightRow(MouseEvent e) {
                        JTable table = (JTable) e.getSource();
                        Point point = e.getPoint();
                        int row = table.rowAtPoint(point);
                        int col = table.columnAtPoint(point);

                        table.setRowSelectionInterval(row, row);
                        table.setColumnSelectionInterval(col, col);
                    }

                });
            }
        });
    }

    public class FirstCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {

            File f = (File) value;

            super.getTableCellRendererComponent(table,
                            value, isSelected, hasFocus, row, column);
            String prefix = f.isDirectory() ? "DIR" : "FILE";
            setText(prefix);

            return this;
        }
    }

    public class CopyAction extends AbstractAction {

        private JTable table;

        public CopyAction(JTable table) {
            this.table = table;
            putValue(NAME, "Copy");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();

            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.setContents(new CellTransferable(table.getValueAt(row, col)), null);
        }

    }

    public class PasteAction extends AbstractAction {

        private JTable table;

        public PasteAction(JTable table) {
            this.table = table;
            putValue(NAME, "Paste");
            final Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            cb.addFlavorListener(new FlavorListener() {
                @Override
                public void flavorsChanged(FlavorEvent e) {
                    setEnabled(cb.isDataFlavorAvailable(CellTransferable.CELL_DATA_FLAVOR));
                }
            });
            setEnabled(cb.isDataFlavorAvailable(CellTransferable.CELL_DATA_FLAVOR));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();

            Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
            if (cb.isDataFlavorAvailable(CellTransferable.CELL_DATA_FLAVOR)) {
                try {
                    Object value = cb.getData(CellTransferable.CELL_DATA_FLAVOR);
                    table.setValueAt(value, row, col);
                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    public static class CellTransferable implements Transferable {

        public static final DataFlavor CELL_DATA_FLAVOR = new DataFlavor(Object.class, "application/x-cell-value");

        private Object cellValue;

        public CellTransferable(Object cellValue) {
            this.cellValue = cellValue;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{CELL_DATA_FLAVOR};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return CELL_DATA_FLAVOR.equals(flavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            if (!isDataFlavorSupported(flavor)) {
                throw new UnsupportedFlavorException(flavor);
            }
            return cellValue;
        }

    }
}