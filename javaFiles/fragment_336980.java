JTable table = new JTable(25, 5)
{
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
    {
        Component c = super.prepareRenderer(renderer, row, column);

        if (isRowSelected(row)) return c;

        //  Customize row colors

        c.setBackground( getBackground() );
        c.setForeground( getForeground() );

        if (row < 4)
        {
            c.setBackground(Color.BLUE);
            c.setForeground(Color.WHITE);
        }
        else if (row < 6)
        {
            c.setBackground(Color.orange);
            c.setForeground(Color.BLACK);
        }
        else if (row >= 17 && row < 20)
        {
            c.setBackground(Color.RED);
            c.setForeground(Color.WHITE);
        }

        return c;
    }
};