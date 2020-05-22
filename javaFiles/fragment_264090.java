for (int i = 0; i < jTable1.getColumnCount(); i ++) {
    TableColumn col = jTable1.getColumnModel().getColumn(i);
    col.setCellEditor(new MyTableCellEditor());
}


public class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor {
    JComponent component = new JTextField();
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int rowIndex, int vColIndex) {
        ((JTextField)component).setText((String)value);
        ((JTextField)component).setFont(new java.awt.Font("Arial Unicode MS", 0, 12));
        return component;
    }
}