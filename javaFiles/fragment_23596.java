@Override
public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
    Component comp = super.getTableCellRendererComponent(table, value,
            isSelected, hasFocus, row, column);

    Color color = map.get(row);
    if (color != null) {
        comp.setBackground(color);
    }

    return comp;
}