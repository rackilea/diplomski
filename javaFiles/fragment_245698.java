JTable table = new JTable(...)
{
    public String getToolTipText( MouseEvent e )
    {
        int row = rowAtPoint( e.getPoint() );
        int column = columnAtPoint( e.getPoint() );

        Object value = getValueAt(row, column);
        return value == null ? null : value.toString();
    }
};