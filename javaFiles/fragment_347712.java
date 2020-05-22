public boolean isCellEditable(int rowIndex, int columnIndex) {
    boolean isEditable = false;
    if (columnIndex >= 1 && columnIndex <= 9) {
        Object value = getValueAt(rowIndex, 0);
        if (value instance Boolean) {
           isEditable = !((boolean)value);
        } 
    } else {
        // Other columns...
    }
    return isEditable
}