model = new DefaultTableModel()
{
    @Override
    public Class getColumnClass (int column)
    {
        return (column == 0) ? Integer.class : String.class;
    }
};