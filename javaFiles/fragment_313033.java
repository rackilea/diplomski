class MyTableHeaderRenderer implements TableCellRenderer
{
    private TableCellRenderer tableCellRenderer;

    public MyTableHeaderRenderer(TableCellRenderer tableCellRenderer)
    {
        this.tableCellRenderer = tableCellRenderer;
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component c = tableCellRenderer.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column);

        if (column == table.getSelectedColumn())
            c.setFont(getFont().deriveFont(Font.BOLD));

        return c;
    }
}