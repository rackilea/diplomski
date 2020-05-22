class MyBooleanRenderer implements TableCellRenderer {

    private static final long serialVersionUID = 1L;

    JCheckBox check = new JCheckBox();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int column) {
        check.setSelected(false);
        if (obj instanceof Boolean) {
            check.setSelected((Boolean)obj);
        }
        if (isSelected) {
            check.setForeground(table.getSelectionForeground());
            check.setBackground(table.getSelectionBackground());
        } else {
            check.setForeground(table.getForeground());
            check.setBackground(table.getBackground());
        }
        return check;
    }
}