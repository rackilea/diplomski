public class MyRenderer implements TableCellRenderer {
    private TableCellRenderer parent;
    private Border emptyBorder = BorderFactory.createEmptyBorder();

    private MyRenderer(TableCellRenderer parent) {
        this.parent = parent;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel headerLabel = (JLabel) parent.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        headerLabel.setBorder(emptyBorder);
        return headerLabel;
    }
}