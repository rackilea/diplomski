@Override
public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
    Component comp = super.getTableCellRendererComponent(table, value,
            isSelected, hasFocus, row, column);

    for (Map.Entry<Integer, Color> enp : map.entrySet()) {
        int key = enp.getKey();

        if (key == row) {
            comp.setBackground(enp.getValue());
        }

    }

    return comp;
}