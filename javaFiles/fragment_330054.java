JTable table1 = new JTable()
{
    @Override
    public Dimension getPreferredScrollableViewportSize()
    {
        return new Dimension(100, 100);
    }
};

...

JTable table2 = new JTable()
{
    @Override
    public Dimension getPreferredScrollableViewportSize()
    {
        return new Dimension(200, 100);
    }
};