public static String[] getJTableSelectedRowsData(JTable theTable) {
    // Gets the data contained within all Selected Table Rows.
    // Each array element within the returned string array will
    // contain a Pipe delimited data string of each selected row.
    int[] selectedRows = theTable.getSelectedRows();
    String[] resultArray = new String[selectedRows.length];

    DefaultTableModel dtm = (DefaultTableModel) theTable.getModel();
    int nCol = dtm.getColumnCount();

    for (int i = 0; i < selectedRows.length; i++) {
        String resultString = "";
        for (int j = 0; j < nCol; j++) {
            resultString += resultString.equals("") ? dtm.getValueAt(selectedRows[i], j).toString()
                    : "|" + dtm.getValueAt(selectedRows[i], j).toString();
        }
        resultArray[i] = resultString;
    }
    return resultArray;
}