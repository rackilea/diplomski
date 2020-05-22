private static final int IMPACT_COL = 0;
private static final Font IMPACT_FONT = new Font("impact", Font.PLAIN, 20);
...
JTextField impactField = getFontEditorField(IMPACT_FONT);
TableColumn impactColumn = table.getColumnModel().getColumn(IMPACT_COL);
impactColumn.setCellEditor(new DefaultCellEditor(impactField));
...
public JTextField getFontEditorField(Font font) {
    JTextField field = new JTextField();
    field.setFont(font);
    return field;
}