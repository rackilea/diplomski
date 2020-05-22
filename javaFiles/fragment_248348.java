import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TablePrepareRenderer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;

    public TablePrepareRenderer() {
        Object[] columnNames = {"Type", "Company", "Shares", "Price", "Boolean"};
        Object[][] data = {
            {"Buy", "IBM", new Integer(1000), new Double(80.50), false},
            {"Sell", "MicroSoft", new Integer(2000), new Double(6.25), true},
            {"Sell", "Apple", new Integer(3000), new Double(7.35), true},
            {"Buy", "Nortel", new Integer(4000), new Double(20.00), false}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
            /*@Override
            public Class getColumnClass(int column) {
            switch (column) {
            case 0:
            return String.class;
            case 1:
            return String.class;
            case 2:
            return Integer.class;
            case 3:
            return Double.class;
            default:
            return Boolean.class;
            }
            }*/
        };
        table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                int firstRow = 0;
                int lastRow = table.getRowCount() - 1;
                if (row == lastRow) {
                    ((JComponent) c).setBackground(Color.red);
                } else if (row == firstRow) {
                    ((JComponent) c).setBackground(Color.blue);
                } else {
                    ((JComponent) c).setBackground(table.getBackground());
                }
                return c;
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
    }
    /*private static String[] suffix = new String[]{"", "k", "m", "b", "t"};
    private static int MAX_LENGTH = 4;

    private static String format(double number) {
    String r = new DecimalFormat("##0E0").format(number);
    r = r.replaceAll("E[0-9]", suffix[Character.getNumericValue(r.charAt(r.length() - 1)) / 3]);
    return r.length() > MAX_LENGTH ? r.replaceAll("\\.[0-9]+", "") : r;
    }*/

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception fail) {
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                TablePrepareRenderer frame = new TablePrepareRenderer();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
        /*long[] numbers = new long[]{1000, 5821, 10500, 101800, 2000000, 7800000, 92150000, 123200000, 99999900};
        for (long number : numbers) {
        System.out.println(number + " = " + format(number));
        }*/
    }
}