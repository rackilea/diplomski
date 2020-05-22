@Override
public Component getTableCellEditorComponent(JTable table,
        Object value, boolean isSelected, int row, int column) {
    JTextField ec = (JTextField) editorComponent;
    if (isSelected) {
        ec.selectAll();
    }
    return editorComponent;
}