import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * @see https://stackoverflow.com/q/13497276/230513
 */
public class EditableColorColumn {

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new EditableColorColumn().display();
            }
        });
    }

    private void display() {
        JFrame frame = new JFrame("Editable Color Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final TableModel model = new ColorTableModel();
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(400, 150));
        table.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                System.out.println(model.getValueAt(e.getFirstRow(), 0)
                    + " " + model.getValueAt(e.getFirstRow(), 1));
            }
        });

        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class ColorTableModel extends AbstractTableModel {

        String columnNames[] = {"English", "Boolean"};
        Object rowData[][] = {
            {"value1", Boolean.FALSE},
            {"value2", Boolean.TRUE},
            {"value3", Boolean.FALSE},
            {"value4", Boolean.TRUE},
            {"value5", Boolean.FALSE},};

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public int getRowCount() {
            return rowData.length;
        }

        @Override
        public Object getValueAt(int row, int column) {
            return rowData[row][column];
        }

        @Override
        public Class getColumnClass(int column) {
            return (getValueAt(0, column).getClass());
        }

        @Override
        public void setValueAt(Object value, int row, int column) {
            rowData[row][column] = value;
            fireTableCellUpdated(row, column);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return (column != 0);
        }
    }
}