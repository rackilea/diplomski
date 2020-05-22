import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class Test {

    public static void main(String... args) {
        JFrame frame = new JFrame();
        final Vector<String> string = new Vector<String>();
        final JTable table = new JTable(getTableModel("First", 1));
        final JTable table2 = new JTable(getTableModel("Second", 3));
        final JButton click = new JButton("Click me");
        final JScrollPane scrollPane = new JScrollPane(table);
        click.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (table2.getParent() == null) {
                    scrollPane.setViewportView(table2);
                } else {
                    scrollPane.setViewportView(table);
                }
            }
        });
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(click, BorderLayout.EAST);
        panel.add(scrollPane);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private static TableModel getTableModel(final String prefix, final int colCount) {
        return new TableModel() {

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                // TODO Auto-generated method stub

            }

            @Override
            public void removeTableModelListener(TableModelListener l) {
                // TODO Auto-generated method stub

            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return prefix + "Hello cell (" + rowIndex + "," + columnIndex + ")";
            }

            @Override
            public int getRowCount() {
                return 30;
            }

            @Override
            public String getColumnName(int columnIndex) {
                return "Column " + columnIndex;
            }

            @Override
            public int getColumnCount() {
                return colCount;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }

            @Override
            public void addTableModelListener(TableModelListener l) {
                // TODO Auto-generated method stub

            }
        };
    }

}