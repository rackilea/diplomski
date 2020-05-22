int [] toDelete = dataTable.getSelectedRows();
Arrays.sort(toDelete); // be shure to have them in ascending order.
MyTableModel myTableModel = (MyTableModel)dataTable.getModel();
for(int ii = toDelete.length -1; ii >=0; ii--) {
    myTableModel.removeRow(toDelete[ii]); // beginning at the largest.
}