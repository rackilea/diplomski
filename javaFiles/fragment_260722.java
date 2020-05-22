public class MyDefaultCellEditor extends DefaultCellEditor {
    public MyDefaultCellEditor() {
        super(new JTextField());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
            int column) {
        JTextField textField = (JTextField) super.getTableCellEditorComponent(table, value, isSelected, row, column);
        Cell cell = (Cell) value;

        textField.setText(cell.getEditorText());
        return textField;
    }
}