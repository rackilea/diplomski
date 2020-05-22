@Override
public void start(Stage primaryStage) {
    StackPane root = new StackPane();
    Scene scene = new Scene(root, 300, 250);
    ObservableList<String> list = FXCollections.observableArrayList();
    list.add("Product One");
    list.add("Product Two");
    list.add("Product Three");
    list.add("Product Four");

    TableView table = new TableView();
    table.setEditable(true);
    TableColumn productName = new TableColumn("Product Name");
    TableColumn productCode = new TableColumn("Product Code");

    productName.setEditable(true);
    //productName.setCellValueFactory(ComboBoxTableCell.forTableColumn(list));
    productName.setCellFactory(new Callback<TableColumn, TableCell>() {
        @Override
        public TableCell call(TableColumn param) {
            return new TableCell() {
                private ComboBox comboBox;

                @Override
                protected void updateItem(Object item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        setGraphic(getComboBox());
                    } else {
                        setGraphic(null);
                    }
                }

                public ComboBox getComboBox() {
                    if (comboBox == null) {
                        comboBox = new ComboBox();
                        comboBox.setEditable(true);
                        comboBox.setItems(list);
                        TextFields.bindAutoCompletion(comboBox.getEditor(), comboBox.getItems());
                    }
                    return comboBox;
                }
            };
        }
    });

    productName.setMinWidth(100);
    productCode.setMinWidth(100);

    table.getColumns().addAll(productName, productCode);
    table.getItems().add(new Object[]{null, null});

    root.getChildren().add(table);

    primaryStage.setTitle("Test");
    primaryStage.setScene(scene);
    primaryStage.show();
}