import java.awt.Component;
import java.awt.EventQueue;
import java.util.Vector;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultTableModel model = new DefaultTableModel(new Object[]{"A", "B", "C", "D"}, 0);
                for (int row = 0; row < 10; row++) {
                    Vector data = new Vector(model.getColumnCount());
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        data.add(row + "x" + col);
                    }
                    model.addRow(data);
                }

                JTable table = new JTable(model);
                table.setDefaultEditor(Object.class, CleanCellEditor.make());

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class CleanCellEditor extends DefaultCellEditor {

        public static CleanCellEditor make() {
            JTextField field = new JTextField();
            field.setBorder(null);
            System.out.println("make");

            return new CleanCellEditor(field);
        }

        public CleanCellEditor(JTextField textField) {
            super(textField);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return super.getTableCellEditorComponent(table, null, isSelected, row, column);
        }

    }

}