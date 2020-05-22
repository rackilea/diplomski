import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

public class CustomRenderer extends JPanel {

    private JTable table = new JTable();
    private DefaultTableModel dtmInsurance;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new CustomRenderer());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public CustomRenderer() {
        setLayout(new BorderLayout());
        table.setModel(getDtmInsurance());
        TableColumn column = table.getColumnModel().getColumn(1);
        column.setCellEditor(new MyBooleanEditor());
        column.setCellRenderer(new MyBooleanRenderer());
        add(new JScrollPane(table));
    }

    public DefaultTableModel getDtmInsurance() {
        if (dtmInsurance == null) {
            String[] columns = {"LIC ID", "Delete"};
            dtmInsurance = new DefaultTableModel(columns, 0) {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 1) {
                        return true;
                    }
                    return false;
                }
            };
            dtmInsurance.setColumnIdentifiers(columns);
            table.setModel(dtmInsurance);
            Object[] addInsurance = {"0", false};
            dtmInsurance.addRow(addInsurance);
        }

        return dtmInsurance;
    }

    class MyBooleanRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        JCheckBox check = new JCheckBox();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);
            if (obj instanceof Boolean) {
                return check;
            }
            return cell;
        }
    }

    public class MyBooleanEditor extends AbstractCellEditor implements TableCellEditor {

        private JCheckBox check = new JCheckBox();

        @Override
        public Object getCellEditorValue() {
            return check.isSelected();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value instanceof Boolean) {
                check.setSelected((Boolean)value);
            }
            return check;
        }
    }
}