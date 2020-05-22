class CheckBoxCellRenderer implements TableCellRenderer {

    private final JCheckBox renderer;

    public CheckBoxCellRenderer() {
        renderer = new JCheckBox();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Color bg = isSelected 
                ? table.getSelectionBackground() : table.getBackground();

        renderer.setBackground(bg);
        renderer.setEnabled(table.isCellEditable(row, column));
        renderer.setSelected(value != null && (Boolean)value);
        return renderer;
    }
}