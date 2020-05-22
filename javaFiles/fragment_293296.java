@Override
public void setValueAt(Object value, int row, int column)
{
    super.setValueAt(value, row, column);

    if (column == 0)
    {
        String name = lookupName(...);
        super.setValueAt(name, row, 1);
    }
}