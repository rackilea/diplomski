import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import static javax.swing.SortOrder.ASCENDING;
import static javax.swing.SortOrder.DESCENDING;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TestColumnHighlight {

    public static void main(String[] args) {
        new TestColumnHighlight();
    }

    public TestColumnHighlight() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JTable table = new JTable();
                DefaultTableModel model = new DefaultTableModel(
                                new Object[]{"abc", "def", "ghi", "jkl"},
                                0);

                model.addRow(new Object[]{0, 0, 0, 0});
                model.addRow(new Object[]{0, 0, 0, 0});
                model.addRow(new Object[]{0, 0, 0, 0});
                model.addRow(new Object[]{0, 0, 0, 0});
                model.addRow(new Object[]{0, 0, 0, 0});

                table.setModel(model);
                table.setTableHeader(new CustomTableHeader(table));
                table.getTableHeader().setDefaultRenderer(new ColumnHeaderRenderer());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class CustomTableHeader extends JTableHeader {

        public CustomTableHeader(JTable table) {
            super();
            setColumnModel(table.getColumnModel());
            table.getColumnModel().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    repaint();
                }
            });
        }

        @Override
        public void columnSelectionChanged(ListSelectionEvent e) {
            repaint();
        }

    }

    public class ColumnHeaderRenderer extends DefaultTableHeaderCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);

            int selectedColumn = table.getSelectedColumn();
            System.out.println("Selected " + selectedColumn + "-" + column);
            if (selectedColumn == column) {
                Color bg = table.getSelectionBackground();
                setBackground(bg);
                setOpaque(true);
            } else {
                setOpaque(false);
            }

            return this;
        }

    }

    public class DefaultTableHeaderCellRenderer extends DefaultTableCellRenderer {

        public DefaultTableHeaderCellRenderer() {
            setHorizontalAlignment(CENTER);
            setHorizontalTextPosition(LEFT);
            setVerticalAlignment(BOTTOM);
            setOpaque(false);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
            JTableHeader tableHeader = table.getTableHeader();
            if (tableHeader != null) {
                setForeground(tableHeader.getForeground());
            }
            setIcon(getIcon(table, column));
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            return this;
        }

        protected Icon getIcon(JTable table, int column) {
            SortKey sortKey = getSortKey(table, column);
            if (sortKey != null && table.convertColumnIndexToView(sortKey.getColumn()) == column) {
                switch (sortKey.getSortOrder()) {
                    case ASCENDING:
                        return UIManager.getIcon("Table.ascendingSortIcon");
                    case DESCENDING:
                        return UIManager.getIcon("Table.descendingSortIcon");
                }
            }
            return null;
        }

        protected SortKey getSortKey(JTable table, int column) {
            RowSorter rowSorter = table.getRowSorter();
            if (rowSorter == null) {
                return null;
            }

            List sortedColumns = rowSorter.getSortKeys();
            if (sortedColumns.size() > 0) {
                return (SortKey) sortedColumns.get(0);
            }
            return null;
        }
    }
}