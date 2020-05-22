public class CleanCellEditor extends DefaultCellEditor {

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