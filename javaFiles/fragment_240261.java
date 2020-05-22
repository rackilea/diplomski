public int[] findValue(TableModel mdl, Object value) {
    int[] returnVal = {-1, -1}; // default returnVal if value is not found
        // iterate over rows
        for(int row = 0 ; row < mdl.getRowCount() ; row++){
            // iterate over columns
            for(int col = 0 ; col < mdl.getColumnCount() ; col++) {
                // if table cell is null it is ignored
                if (mdl.getValueAt(row, col) != null && mdl.getValueAt(row, col).equals(value)) {
                    returnVal[0] = row;
                    returnVal[1] = col;
                    return returnVal;
                }
            }
        }
    return returnVal;
}