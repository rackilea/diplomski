public class TableEditorTest {

    public static void main(String[] args) {
        Object[][] data = new Object[][] {{"Identifier", "ST33442"}, {"Purchase Date", new Date()}, {"Status", Boolean.FALSE}};
        String[] columnNames = new String[] {"Name", "Value"};
        TableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);

        table.getColumnModel().getColumn(1).setCellEditor(new CustomTableCellEditor());
    }

    public static class CustomTableCellEditor extends AbstractCellEditor implements TableCellEditor {
        private TableCellEditor editor;

        @Override
        public Object getCellEditorValue() {
            if (editor != null) {
                return editor.getCellEditorValue();
            }

            return null;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value instanceof Date) {
                editor = new DatePickerCellEditor();
            } else if (value instanceof String) {
                editor = new DefaultCellEditor(new JTextField());
            } else if (value instanceof Boolean) {
                editor = new DefaultCellEditor(new JCheckBox());
            }

            return editor.getTableCellEditorComponent(table, value, isSelected, row, column);
        }
    }
}