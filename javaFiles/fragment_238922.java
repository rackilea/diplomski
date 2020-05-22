@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean hasFocus, int row, int col) {
    setText(value.toString());

    Dimension preferredSize = getPreferredSize();
    setSize(new Dimension(preferredSize.width, 1000));
    preferredSize = getPreferredSize();

    System.out.format("Row %d preferred size %s%n", row, preferredSize);
    if (preferredSize.height > 0 && table.getRowHeight(row) != preferredSize.height) {
        table.setRowHeight(row, preferredSize.height);
    }
    return this;
}