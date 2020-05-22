public boolean isTableEmpty(JTable jTable) {
    TableModel tableModel = jTable.getModel();

    // if model has no rows -- table is empty
    if (tableModel.getRowCount == 0) {
        return true;
    }

    // if model has rows, check each cell for non-null data
    for (int i = 0; i < tableModel.getRowCount(); i++) {
        for(int j = 0; j < tableModel.getColumnCount(); j++) {
            if (tableModel.getValueAt(i, j) != null) {
                // if any cell has data, then the table is not empty
                return false;
            }
        }
    }

    // all cells hold null values
    return true;
}