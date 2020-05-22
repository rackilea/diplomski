TableView<Game> table = new TableView<>();
TableColumn<Game, String> idColumn = new TableColumn<>("ID");
idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
TableColumn<Game, String> saveFileNameColumn = new TableColumn<>("Save file name");
saveFileNameColumn.setCellValueFactory(cellData -> cellData.getValue().saveFileNameProperty());
TableColumn<Game, ObservableList<String>> playerNamesColumn = new TableColumn<>("Player names");
playerNamesColumn.setCellValueFactory(cellData -> callData.getValue().playerNamesProperty());

table.setItems(buildTableModel());

table.getColumns().addAll(idColumn, saveFileNameColumn, playerNamesColumn);