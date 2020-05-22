import java.awt.*;
import java.text.NumberFormat;
import javax.swing.*;
import javax.swing.table.*;

public class TableExample {

    private static final long CUSP = 20000000;
    private JFrame frame = new JFrame("Table Demo");
    private Icon errorIcon = (Icon) UIManager.getIcon("OptionPane.errorIcon");
    private Icon infoIcon = (Icon) UIManager.getIcon("OptionPane.informationIcon");
    private Icon warnIcon = (Icon) UIManager.getIcon("OptionPane.warningIcon");
    private String[] columnNames = {"String", "Long", "Float", "Double", "Boolean", "Icon"};
    private Object[][] data = {
        {"aaa", CUSP - 1, 12.15F, 100.05, true, (errorIcon)},
        {"bbb", CUSP, 7.154F, 6.1555, false, (infoIcon)},
        {"ccc", CUSP + 1, 0.1135F, 3.1455, true, (warnIcon)},
        {"ddd", 42L, 31.15F, 10.05, true, (errorIcon)},
        {"eee", 12345L, 5.154F, 16.1555, false, (infoIcon)},
        {"fff", 54321L, 4.1135F, 31.1455, true, (warnIcon)}};
    private final TableModel model = new DefaultTableModel(data, columnNames) {

        @Override
        public Class<?> getColumnClass(int column) {
            switch (column) {
                case 0:
                    return String.class;
                case 1:
                    return Long.class;
                case 2:
                    return Float.class;
                case 3:
                    return Double.class;
                case 4:
                    return Boolean.class;
                case 5:
                    return Icon.class;
                default:
                    return String.class;
            }
        }
    };
    private final JTable table = new JTable(model);

    private static class PopulationRenderer extends DefaultTableCellRenderer {

        NumberFormat f = NumberFormat.getInstance();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int col) {
            JLabel r = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, col);
            if (col == 1) {
                r.setHorizontalAlignment(JLabel.RIGHT);
                Long population = (Long) value;
                if (population > CUSP) {
                    r.setForeground(Color.red);
                } else {
                    r.setForeground(Color.BLACK);
                }
                r.setText(f.format(population));
            }
            return r;
        }
    }

    public TableExample() {
        int h = infoIcon.getIconHeight();
        table.setRowHeight(h);
        table.setPreferredScrollableViewportSize(
            new Dimension(table.getPreferredSize().width, 4 * h));
        table.setAutoCreateRowSorter(true);
        table.setDefaultRenderer(Long.class, new PopulationRenderer());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            TableExample tableExample = new TableExample();
        });
    }
}