@Override
public Component getTableCellRendererComponent(
    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
{
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    if (isSelected)
        setBackground( table.getSelectionBackground() );
    else if (yourSet.contains(row))
        setBackground( Color.CYAN );
    else
        setBackground( table.getBackground() );

    return this;
}