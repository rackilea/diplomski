String searchedId = "867954";//ID of the product to remove from the table
int row = -1;//index of row or -1 if not found

//search for the row based on the ID in the first column
for(int i=0;i<dtm.getRowCount();++i)
    if(dtm.getValueAt(i, 0).equals(searchedId))
    {
        row = i;
        break;
    }

if(row != -1)
    dtm.removeRow(row);//remove row

else
    ...//not found