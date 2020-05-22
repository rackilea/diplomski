@FXML
private TableView<String> tableView;

@FXML
private TableColumn<String, String> columnOne;

@FXML
private TableColumn<String, String> columnTwo;

columnOne.setCellValueFactory(c -> new SimpleStringProperty(new String("123")));

columnTwo.setCellValueFactory(c -> new SimpleStringProperty(new String("456")));