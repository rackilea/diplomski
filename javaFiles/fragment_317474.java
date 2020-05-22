public class MyCellEditor extends AbstractCellEditor implements TableCellEditor {

    private static final long serialVersionUID = 1L;

    JTextField textField = new JTextField("");

    @Override
    public boolean isCellEditable(EventObject e) {
        if (super.isCellEditable(e)) {
            if (e instanceof MouseEvent) {
                MouseEvent me = (MouseEvent) e;
                return me.getClickCount() >= 2;
            }
            if (e instanceof KeyEvent) {
                KeyEvent ke = (KeyEvent) e;
                return ke.getKeyCode() == KeyEvent.VK_F2;
            }
        }
        return false;
    }

    @Override
    public Object getCellEditorValue() {
        return this.textField.getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.textField.setFont(table.getFont());
        this.textField.setText(value.toString());
        return this.textField;
    }
    return false;
}