@FXML
TableView myTable;

@Override
public void initialize(URL url, ResourceBundle rb) {
    TableColumn<Item, String> firstColumn = new TableColumn<>("First Column");
    firstColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> p) {
            return new ReadOnlyObjectWrapper(p.getValue().column1);
        }
    });

    TableColumn<Item, String> secondColumn = new TableColumn<>("Second Column");
    secondColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, String>, ObservableValue<String>>() {
        @Override
        public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> p) {
            return new ReadOnlyObjectWrapper(p.getValue().column2);
        }
    });

    TableColumn<Item, Button> buttonCol = new TableColumn<>("ButtonColumn");
    buttonCol.setSortable(false);
    buttonCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Item, Button>, ObservableValue<Button>>() {
        @Override
        public ObservableValue<Button> call(TableColumn.CellDataFeatures<Item, Button> features) {
            return new ReadOnlyObjectWrapper(features.getValue().button);
        }
    });
    myTable.getColumns().add(buttonCol);
    myTable.getColumns().add(firstColumn);
    myTable.getColumns().add(secondColumn);
    myTable.getItems().add(new Item("Test 1", "Test 1", new Button("Test 1"), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
            //ON ACTION CODE HERE
            System.out.println("TEST 1 CLICKED!");
        }
    }));
    myTable.getItems().add(new Item("Test 2", "Test 2", new Button("Test 2"), new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
            //ON ACTION CODE HERE
            System.out.println("TEST 2 BUTTON CLICKED");
        }
    }));
}