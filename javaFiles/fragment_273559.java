// Access the currently selected row.
int rowIndex = tbl.getSelectedRow();

// -1 denotes no row selected, check against that.
if (rowIndex >= 0){
    // Remove the row from the table.
    dtm.removeRow(rowIndex);
}