class AllTableModel extends AbstractTableModel {

    // Suppose this is the data list table is using,
    List<TableData> tableData = new ArrayList<TableData>();

    // Override methods goes here.

    public void setTableData(List<TableData> tableData) {
        this.tableData = tableData;
        fireTableDataChanged();
}  
}