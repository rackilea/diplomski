@Override
     public void setValueAt(Object aValue, int row, int col) 
     {
          //your default code here
           and then you should call 
           fireTableRowsUpdated(row,row); // if you change the row
           OR
           fireTableCellUpdated(row,col); // if you change the cell
           OR
           fireTableDataChanged(); // if you change all the model  

     }