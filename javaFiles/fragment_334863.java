private TableView<String> table = new TableView<String>();

TableColumn columnOne = new TableColumn("One");
TableColumn columnTwo = new TableColumn("Two");

table.getColumns().addAll(columnOne, columnTwo);

columnOne.setCellValueFactory(c -> new SimpleStringProperty(new String("123")));
columnTwo.setCellValueFactory(c -> new SimpleStringProperty(new String("456")));

table.getItems().addAll("Column one's data", "Column two's data");