import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @see https://stackoverflow.com/a/12352838/230513
 */
public class ModifiedCells extends JPanel {

    public ModifiedCells() {
        final MyModel model = new MyModel();
        JTable table = new JTable(model);
        table.setDefaultRenderer(String.class, new MyRenderer());
        table.setDefaultEditor(String.class, new MyEditor(table));
        this.add(table);
    }

    private static class MyRenderer extends DefaultTableCellRenderer {

        Color backgroundColor = getBackground();

        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
            MyModel model = (MyModel) table.getModel();
            if (model.getState(row)) {
                c.setBackground(Color.green.darker());
            } else if (!isSelected) {
                c.setBackground(backgroundColor);
            }
            return c;
        }
    }

    private static class MyEditor extends DefaultCellEditor {

        private JTable table;
        private MyModel model;

        public MyEditor(JTable table) {
            super(new JTextField());
            this.table = table;
            this.model = (MyModel) table.getModel();
        }

        @Override
        public boolean stopCellEditing() {
            model.setState(table.getEditingRow(), true);
            return super.stopCellEditing();
        }
    }

    private static class MyModel extends AbstractTableModel {

        private final List<Row> list = new ArrayList<Row>();

        public MyModel() {
            list.add(new Row("One", true));
            list.add(new Row("Two", false));
            list.add(new Row("Three", false));
        }

        public boolean getState(int row) {
            return list.get(row).state.booleanValue();
        }

        public void setState(int row, boolean state) {
            list.get(row).state = state;
        }

        @Override
        public int getRowCount() {
            return list.size();
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return list.get(row).name;
        }

        @Override
        public void setValueAt(Object aValue, int row, int col) {
            list.get(row).name = (String) aValue;
            fireTableCellUpdated(row, col);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        private static class Row {

            private String name;
            private Boolean state;

            public Row(String name, Boolean state) {
                this.name = name;
                this.state = state;
            }
        }
    }

    private void display() {
        JFrame f = new JFrame("ModifiedCells");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ModifiedCells().display();
            }
        });
    }
}