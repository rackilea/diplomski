import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * @author dic19
 */
public class Demo {

    private void createAndShowGui() {

        DefaultTableModel model = new DefaultTableModel(5, 6) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch(columnIndex) {
                    case 4:
                    case 5: return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 5) {
                    Object value = getValueAt(row, 4);
                    return value != null && (Boolean)value;
                }
                return super.isCellEditable(row, column);
            }

            @Override
            public void setValueAt(Object aValue, int row, int column) {
                if(column == 4) {
                    super.setValueAt(false, row, 5);
                } 
                super.setValueAt(aValue, row, column);
            }
        };

        JTable table = new JTable(model);
        table.getDefaultRenderer(null);
        table.getColumnModel().getColumn(5).setCellRenderer(new CheckBoxCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    class CheckBoxCellRenderer implements TableCellRenderer {

        private final JCheckBox renderer;

        public CheckBoxCellRenderer() {
            renderer = new JCheckBox();
            renderer.setHorizontalAlignment(SwingConstants.CENTER);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            Color bg = isSelected 
                    ? table.getSelectionBackground() : table.getBackground();

            renderer.setBackground(bg);
            renderer.setEnabled(table.isCellEditable(row, column));
            renderer.setSelected(value != null && (Boolean)value);
            return renderer;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().createAndShowGui();
            }
        });
    }
}