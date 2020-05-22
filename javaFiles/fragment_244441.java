@Override
public Object getValueAt(int row, int column)
{
    //return Integer.toString(row + 1);
    if (main.isRowSelected(row))
        return "\u25BA";
    else
        return " ";
}