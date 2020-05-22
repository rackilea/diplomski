import java.awt.Color;
import java.awt.Component;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class TestTable {

    public class MyTableCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setBackground(null);
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setText(String.valueOf(value));
            boolean interestingRow = row % 5 == 2;
            boolean secondColumn = column == 1;
            if (interestingRow && secondColumn) {
                setBackground(Color.ORANGE);
            } else if (interestingRow) {
                setBackground(Color.YELLOW);
            } else if (secondColumn) {
                setBackground(Color.RED);
            }
            return this;
        }

    }

    private JFrame f;
    private JTable table;

    protected void initUI() {
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        Vector<String> columNames = new Vector<String>();
        columNames.add("Col 0");
        columNames.add("Col 1");
        columNames.add("Col 2");
        for (int i = 0; i < 20; i++) {
            Vector<Object> v = new Vector<Object>();
            v.add(i % 3 == 0 ? "Hello" : "World");
            v.add("Some data in row " + (i + 1));
            v.add("Some other data in row " + (i + 1));
            data.add(v);
        }
        table = new JTable(new DefaultTableModel(data, columNames));
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new MyTableCellRenderer());
        }
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(new JScrollPane(table));
        f.pack();
        f.setVisible(true);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TestTable().initUI();
            }
        });
    }

}