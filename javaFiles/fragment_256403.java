int rowModelId = convertRowIndexToModel( row );
for (int c = 0; c < headerCols.size(); c++) {
    newRow.put(
        headerCols.get(c),
        (String) tableModel.getValueAt(rowModelId, c)
    );
}