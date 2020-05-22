JXTable table = new JXTable(new CustomTableModel())
{
    public Component prepareRenderer(
        TableCellRenderer renderer, int row, int column)
    {
        Component c = super.prepareRenderer(renderer, row, column);

        if (column == getSelectedColumn()) { c.setBackground(Color.RED); }
        else if (row == getSelectedRow()) { c.setBackground(Color.YELLOW); }
        else c.setBackground(getBackground());

        return c;
    }
};