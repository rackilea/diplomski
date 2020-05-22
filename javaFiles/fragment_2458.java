void populateCalculationsTableData() {
    ...
    calculationsTableData = temp;
    DefaultTableModel model = (DefaultTableModel)calculationsTable.getModel();
    model.setDataVector(calculationsTableData, calculationsColumnNames);
}