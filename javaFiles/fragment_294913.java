import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Demo {

    /** @see https://stackoverflow.com/a/6644956/230513 */
    private static class HeaderRenderer implements TableCellRenderer {

        TableCellRenderer renderer;

        public HeaderRenderer(JTable table) {
            renderer = table.getTableHeader().getDefaultRenderer();
        }

        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int col) {
            // assumes JLabel
            JLabel label = (JLabel) renderer.getTableCellRendererComponent(
                       table, value, isSelected, hasFocus, row, col);
            label.setHorizontalAlignment(JLabel.LEADING);
            return label;
        }
    }

    private void initGUI() {
        Object[] columnNames = new Object[]{
            "Image Name", "Created At", "Status", "Image Id", "Volume Id"};
        DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
        dtm.addRow(new Object[]{"Some picture's name", "2013-10-05",
            "Status unknown", "0123456789", "9876543210"});

        JTable table = new JTable(dtm);
        table.getTableHeader().setDefaultRenderer(new HeaderRenderer(table));

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel content = new JPanel(new BorderLayout());
        content.setPreferredSize(new Dimension(600, 250));
        content.add(scrollPane);

        JFrame frame = new JFrame("Demo");
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().initGUI();
            }
        });
    }
}