import javax.swing.*;
import javax.swing.table.*;

public class TablePanel extends JPanel {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("JTable");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.add(new TablePanel());
                f.pack();
                f.setVisible(true);
            }
        });
    }

    public TablePanel() {
        TableModel dataModel = new MyTableModel();
        JTable table = new JTable(dataModel);
        table.setAutoCreateRowSorter(true);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        JScrollPane jsp = new JScrollPane(table);
        this.add(jsp);
    }

    private static class MyTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return 30;
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return Math.pow(row, col + 1);
        }

        @Override
        public Class<?> getColumnClass(int col) {
            return getValueAt(0, col).getClass();
        }
    }
}