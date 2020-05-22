import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Table1 {

    JFrame frame;
    JComboBox credit;
    String[] rowNames = {
        "Vasan Phalke", "Pansare", "Anil Kg", "Suresh", "Total Credit", ""};
    String[] colNames = {"Name", "Qty", "Rate/ Kg", "Total Amt."};
    JTable table;
    DefaultTableModel model;
    JScrollPane scrollPane;

    public Table1() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        credit = new JComboBox<>(rowNames);
        model = new DefaultTableModel(colNames, 6) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return String.class;
                    case 1:
                        return Integer.class;
                    case 2:
                        return Double.class;
                    case 3:
                        return Double.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public Object getValueAt(int row, int col) {
                if (col == 3 & row == 5) {
                    double sum = 0;
                    for (int i = 0; i < 5; i++) {
                        sum += ((Double) getValueAt(i, 3)).doubleValue();
                    }
                    return sum;
                }
                if (col == 3 & row != 5) {
                    Integer i = (Integer) getValueAt(row, 1);
                    Double d = (Double) getValueAt(row, 2);
                    if (i != null && d != null) {
                        return i * d;
                    } else {
                        return 0d;
                    }
                }
                return super.getValueAt(row, col);
            }

            @Override
            public void setValueAt(Object aValue, int row, int col) {
                super.setValueAt(aValue, row, col);
                fireTableDataChanged();
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                return col != 3;
            }
        };
        table = new JTable(model);
        TableColumn nameColumn = table.getColumnModel().getColumn(0);
        nameColumn.setCellEditor(new DefaultCellEditor(credit));
        scrollPane = new JScrollPane(table);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Table1();
            }
        });
    }
}