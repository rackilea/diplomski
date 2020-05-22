import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * @see https://stackoverflow.com/a/37343900/230513
 * @see https://stackoverflow.com/a/37318673/230513
 */
public class Test {

    private void display() {
        JFrame f = new JFrame("Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        class MyTableModel extends AbstractTableModel {

            private int n = 8;

            private void addRow() {
                n++;
                fireTableRowsInserted(n - 1, n - 1);
            }

            @Override
            public int getRowCount() {
                return n;
            }

            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public Object getValueAt(int rowIndex, int colIndex) {
                return "R" + rowIndex + ":C" + colIndex;
            }
        };
        MyTableModel model = new MyTableModel();
        JTable table = new JTable(model) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(super.getPreferredSize().width,
                    getRowHeight() * getRowCount());
            }
        };
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        f.add(new JScrollPane(table));
        f.add(new JButton(new AbstractAction("Add Row") {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow();
                f.pack();
            }
        }), BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Test()::display);
    }
}