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

    public static class HTMLRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setVerticalAlignment(JLabel.TOP);
            return comp;
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