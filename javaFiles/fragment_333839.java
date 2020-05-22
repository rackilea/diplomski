int row = Table.getSelectedRow();

if(row == -1)
{
    // No row selected
    // Show error message
}
else
{
    String Table_click = (Table.getModel().getValueAt(row, 0).toString());
    // do whatever you need to do with the data from the row
}