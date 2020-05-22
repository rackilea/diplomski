@Override
public Class getColumnClass(int column)
{
    if (column == 3)
        return Integer.class;
    else
        return String.class;
}