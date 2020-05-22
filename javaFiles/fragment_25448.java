@Override
public void setValueAt(Object value, int row, int col)
{
    BookInformation book_infos = bData.get(row);
    if (col==0)
    book_infos.setBookName((String)value);
    else if (col==1)
    book_infos.setBookDate((String)value);
    else if (col==2)
    book_infos.setBookID((String)value);
    else if (col==3)
    book_infos.setBorrowStatus((String)value);
    fireTableCellUpdated(row,col);
}