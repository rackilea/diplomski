int numLectures = ... ;
TableView<Row> table = new TableView<>();
TableColumn<Row, String> audienceCol = new TableColumn<>("Audience");
audienceCol.setCellValueFactory(cellData -> cellData.getValue().audienceProperty());
table.getColumns().add(audienceCol);
for (int i = 0 ; i < numLectures ; i++) {
    TableColumn<Row, Attendance> col = new TableColumn<>("Attendance "+ (i+1));
    final int colIndex = i ;
    col.setCellValueFactory(cellData -> cellData.getValue().getLectures().get(colIndex));
    table.getColumns().add(col);
}