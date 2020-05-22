public boolean ifExists(JTable table,string entry) {


    int rowCount = table.getRowCount();
    int columnCount = table.getColumnCount();


    for (int i = 0; i < rowCount; i++) {
        String value = "";
        for (int j = 0; j < columnCount; j++)
            value = value + " " + table.getValueAt(i, j).toString();
        if (value.equalsIgnoreCase(entry)) {
            return true;
        }
    }
    return false;
}