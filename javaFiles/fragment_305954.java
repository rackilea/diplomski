JTable table = getTable();
if (table.getSelectedRowCount() > 0) {
    List<Vector> selectedRows = new ArrayList<>(25);
    DefaultTableModel model = getModel();
    Vector rowData = model.getDataVector();
    for (int row : table.getSelectedRows()) {
        int modelRow = table.convertRowIndexToModel(row);
        Vector rowValue = (Vector) rowData.get(modelRow);
        selectedRows.add(rowValue);
    }