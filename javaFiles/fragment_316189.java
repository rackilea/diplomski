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