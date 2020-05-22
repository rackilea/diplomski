@Override
public Component prepareEditor(TableCellEditor editor, int row, int col) {
    Component c = super.prepareEditor(editor, row, col);
    c.setBackground(color);
    return c;
}