TableView<List<Object>> table = new TableView<>();
DAO dao = new DAO();
DataResult data = dao.getAllData();

for (int i = 0 ; i < data.getNumColumns() ; i++) {
    TableColumn<List<Object>, Object> column = new TableColumn<>(data.getColumnName(i));
    int columnIndex = i ;
    column.setCellValueFactory(cellData -> 
        new SimpleObjectProperty<>(cellData.getValue().get(columnIndex)));
    table.getColumns().add(column);
}

table.getItems().setAll(data.getData());