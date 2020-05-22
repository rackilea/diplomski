void populateCalculationsTableData() {
    ...
    calculationsTableData = temp;
    TableModel model = new DefaultTableModel(calculationsTableData, calculationsColumnNames);
    calculationsTable.setModel(model);
}