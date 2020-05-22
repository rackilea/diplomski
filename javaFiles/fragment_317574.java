int [] selectedRows = table.getSelectedRows();
for (int i = selectedRows.length - 1; i >= 0; i--) {
    int viewIndex = selctedRows[i];
    int modelIndex = table.convertRowIndexToModel(viewIndex);
    model.removeRow(modelIndex);
}