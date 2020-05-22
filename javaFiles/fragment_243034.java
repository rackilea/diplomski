import com.sun.java.swing.Painter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;

public class JTableSortingIconsForNimbus extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private JTable table1;
    private static Icon ascendingSortIcon;
    private static Icon descendingSortIcon;

    public JTableSortingIconsForNimbus() {
        Object[] columnNames = {"Type", "Company", "Shares", "Price"};
        Object[][] data = {
            {"Buy", "IBM", new Integer(1000), new Double(80.50)},
            {"Sell", "MicroSoft", new Integer(2000), new Double(6.25)},
            {"Sell", "Apple", new Integer(3000), new Double(7.35)},
            {"Buy", "Nortel", new Integer(4000), new Double(20.00)}
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
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
        add(scrollPane, BorderLayout.NORTH);
        table1 = new JTable(model) {

            private static final long serialVersionUID = 1L;

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                int firstRow = 0;
                int lastRow = table1.getRowCount() - 1;
                if (row == lastRow) {
                    ((JComponent) c).setBackground(Color.red);
                } else if (row == firstRow) {
                    ((JComponent) c).setBackground(Color.blue);
                } else {
                    ((JComponent) c).setBackground(table1.getBackground());
                }
                return c;
            }
        };
        table1.setPreferredScrollableViewportSize(table1.getPreferredSize());
        JScrollPane scrollPane1 = new JScrollPane(table1);
        //UIDefaults nimbusOverrides = new UIDefaults();
        //nimbusOverrides.put("Table.ascendingSortIcon", ascendingSortIcon);
        //nimbusOverrides.put("Table.descendingSortIcon", descendingSortIcon);
        //table1.putClientProperty("Nimbus.Overrides", nimbusOverrides);
        //UIManager.getLookAndFeelDefaults().put("Table.ascendingSortIcon", ascendingSortIcon);
        //UIManager.getLookAndFeelDefaults().put("Table.descendingSortIcon", descendingSortIcon);
        UIManager.getLookAndFeelDefaults().put("TableHeader[Enabled].ascendingSortIconPainter",
                new FillPainter1(new Color(255, 255, 191)));
        UIManager.getLookAndFeelDefaults().put("TableHeader[Enabled].descendingSortIconPainter",
                new FillPainter1(new Color(191, 255, 255)));


        SwingUtilities.updateComponentTreeUI(table1);
        add(scrollPane1, BorderLayout.SOUTH);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel()) {

            @Override
            public void toggleSortOrder(int column) {
                if (column >= 0 && column < getModelWrapper().getColumnCount() && isSortable(column)) {
                    List<SortKey> keys = new ArrayList<SortKey>(getSortKeys());
                    if (!keys.isEmpty()) {
                        SortKey sortKey = keys.get(0);
                        if (sortKey.getColumn() == column && sortKey.getSortOrder() == SortOrder.DESCENDING) {
                            setSortKeys(null);
                            return;
                        }
                    }
                }
                super.toggleSortOrder(column);
            }
        };
        table.setRowSorter(sorter);
        table1.setRowSorter(sorter);
    }

    static class FillPainter1 implements Painter<JComponent> {

        private final Color color;

        public FillPainter1(Color c) {
            color = c;
        }

        @Override
        public void paint(Graphics2D g, JComponent object, int width, int height) {
            g.setColor(color);
            g.fillRect(0, 0, width - 1, height - 1);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            ascendingSortIcon = UIManager.getLookAndFeelDefaults().getIcon("Table.ascendingSortIcon");
            descendingSortIcon = UIManager.getLookAndFeelDefaults().getIcon("Table.descendingSortIcon");
            UIManager.getLookAndFeelDefaults().put("TableHeader[Enabled].ascendingSortIconPainter",
                    new FillPainter1(new Color(127, 255, 191)));
            UIManager.getLookAndFeelDefaults().put("TableHeader[Enabled].descendingSortIconPainter",
                    new FillPainter1(new Color(191, 255, 127)));
        } catch (Exception fail) {
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JTableSortingIconsForNimbus frame = new JTableSortingIconsForNimbus();
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}