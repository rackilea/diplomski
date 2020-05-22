public int sumRow(TableModel mdl, int row) {
    int total = 0;
    // iterate over all columns
    for (int i = 0 ; i < mdl.getColumnCount() ; i++) {
        // null or not Integer will throw exception
        total += (Integer) mdl.getValueAt(row, i);
    }
    return total;
}