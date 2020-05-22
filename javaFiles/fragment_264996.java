import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import sun.swing.DefaultLookup;

public class TestTable extends JPanel {

    public TestTable() {
        setLayout(new BorderLayout());

        Object[][] rows = {
            {"<html><font color=red>1 Lorem ipsum</font> dolor sit amet, "
                + "consectetur adipiscing elit. In lectus dolor</html>"},
            {"<html><font color=green>2 Lorem ipsum</font> dolor sit amet, "
                + "consectetur adipiscing elit. In lectus dolor</html>"},
            {"<html><font color=blue>3 Lorem ipsum</font> dolor sit amet, "
                + "consectetur adipiscing elit. In lectus dolor</html>"},
            {"<html><font color=red>4 Lorem ipsum</font> dolor sit amet, "
                + "consectetur adipiscing elit. In lectus dolor</html>"},
            {"<html><font color=green>5 Lorem ipsum</font> dolor sit amet, "
                + "consectetur adipiscing elit. In lectus dolor</html>"},};
        Object[] columns = {"Column"};

        DefaultTableModel model = new DefaultTableModel(rows, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable table = new JTable(model);
        table.setDefaultRenderer(Object.class, new HTMLRenderer());
        table.setRowHeight(table.getFont().getSize() * 2);

        add(new JScrollPane(table));

        add(new JLabel(String.format("%s, %s, JRE %s (%s)",
                System.getProperty("os.name"), System.getProperty("os.arch"),
                System.getProperty("java.version"), Locale.getDefault().toString())),
                BorderLayout.SOUTH);
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }

    public static class HTMLRenderer extends JPanel implements TableCellRenderer {

        private JLabel label;
    private static final Border SAFE_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    private static final Border DEFAULT_NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);
    protected static Border noFocusBorder = DEFAULT_NO_FOCUS_BORDER;

        public HTMLRenderer() {
            label = new DefaultTableCellRenderer();
//            setOpaque(false);
            setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            add(label);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (table == null) {
                return this;
            }

            Color fg = null;
            Color bg = null;

            JTable.DropLocation dropLocation = table.getDropLocation();
            if (dropLocation != null
                    && !dropLocation.isInsertRow()
                    && !dropLocation.isInsertColumn()
                    && dropLocation.getRow() == row
                    && dropLocation.getColumn() == column) {

                fg = UIManager.getColor("Table.dropCellForeground");
                bg = UIManager.getColor("Table.dropCellBackground");

                isSelected = true;
            }

            if (isSelected) {
                super.setForeground(fg == null ? table.getSelectionForeground()
                        : fg);
                super.setBackground(bg == null ? table.getSelectionBackground()
                        : bg);
            } else {
                Color background = table.getBackground();
                if (background == null || background instanceof javax.swing.plaf.UIResource) {
                    Color alternateColor = UIManager.getColor("Table.alternateRowColor");
                    if (alternateColor != null && row % 2 != 0) {
                        background = alternateColor;
                    }
                }
                super.setForeground(table.getForeground());
                super.setBackground(background);
            }

            setFont(table.getFont());

            if (hasFocus) {
                Border border = null;
                if (isSelected) {
                    border = UIManager.getBorder("Table.focusSelectedCellHighlightBorder");
                }
                if (border == null) {
                    border = UIManager.getBorder("Table.focusCellHighlightBorder");
                }
                setBorder(border);

                if (!isSelected && table.isCellEditable(row, column)) {
                    Color col;
                    col = UIManager.getColor("Table.focusCellForeground");
                    if (col != null) {
                        super.setForeground(col);
                    }
                    col = UIManager.getColor("Table.focusCellBackground");
                    if (col != null) {
                        super.setBackground(col);
                    }
                }
            } else {
                setBorder(getNoFocusBorder());
            }

            label.setText(value == null ? "" : value.toString());
            return this;
        }
    protected  Border getNoFocusBorder() {
        Border border = UIManager.getBorder("Table.cellNoFocusBorder");
        if (System.getSecurityManager() != null) {
            if (border != null) return border;
            return SAFE_NO_FOCUS_BORDER;
        } else if (border != null) {
            if (noFocusBorder == null || noFocusBorder == DEFAULT_NO_FOCUS_BORDER) {
                return border;
            }
        }
        return noFocusBorder;
    }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationByPlatform(true);

                TestTable panel = new TestTable();
                frame.add(panel);
                frame.pack();

                frame.setVisible(true);
            }
        });
    }
}