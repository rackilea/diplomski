@Override
public void start(Stage primaryStage) {
    TableView<Item> table = new TableView<>();

    Callback<TableColumn<Item, String>, TableCell<Item, String>> factory = column -> new TableCell<Item, String>() {
        private final TextField textField;

        {
            textField = new TextField();
            textField.textProperty().addListener((observable, oldValue, newValue) -> {
                // write to property 
                WritableValue<String> property = (WritableValue<String>) getTableColumn().getCellObservableValue(getIndex());
                property.setValue(newValue);
            });
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setGraphic(null);
            } else {
                setGraphic(textField);
                if (!Objects.equals(textField.getText(), item)) {
                    // only modify if TextField wasn't source of the change
                    // to prevent carret movement
                    textField.setText(item);
                }
            }
        }

    };

    TableColumn<Item, String> formulaColumn = new TableColumn<>("baseFormula");
    formulaColumn.setCellValueFactory(cd -> cd.getValue().baseFormulaProperty());
    formulaColumn.setCellFactory(factory);

    TableColumn<Item, String> ptColumn = new TableColumn<>("basePt");
    ptColumn.setCellValueFactory(cd -> cd.getValue().basePtProperty());
    ptColumn.setCellFactory(factory);

    table.getColumns().addAll(formulaColumn, ptColumn);

    String[][] data = {
        {"Hello", "World"},
        {"Hello2", "World2"},
        {"Hello3", "World3"},
        {"Hello4", "World4"},
        {"Hello5", "World5"},
        {"Hello6", "World6"}
    };

    for (String[] d : data) {
        table.getItems().add(new Item(d[0], d[1]));
    }

    Button btn = new Button("print");
    btn.setOnAction(evt -> System.out.println(table.getItems()));

    Scene scene = new Scene(new VBox(table, btn));

    primaryStage.setScene(scene);
    primaryStage.show();
}