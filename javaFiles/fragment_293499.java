public Component getTableCellEditorComponent(JTable table, Object value, boolean   isSelected, int row, int column) {
    JTextArea area = new JTextArea();
    area.setLineWrap(true);
    area.setText((String) value);

    JScrollPane pane = new JScrollPane(area);

    return pane;
}