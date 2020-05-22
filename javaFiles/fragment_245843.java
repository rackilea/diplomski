@Override
public void setValueAt(Object value, int row, int column)
{
    Entry entry = db.get(row);

    switch (column)
    {
        case 0: entry.setItem(value); break;
        case 1: entry.setTransPayment(value); break;
        ...
    }

    fireTableCellUpdated(row, column);
}