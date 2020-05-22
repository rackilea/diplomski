public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        TableColumn<Item, String> col1 = new TableColumn("Column1");
        col1.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        col1.setCellFactory(column -> new TableCel_Edit());
        TableColumn<Item, Number> col2 = new TableColumn("Column2");
        col2.setCellValueFactory(cellData -> cellData.getValue().valueProperty());
        TableView<Item> table = new TableView();
        table.setEditable(true);
        table.getItems().addAll(loadData());
        table.getColumns().addAll(col1, col2);
        AnchorPane root = new AnchorPane();
        root.getChildren().add(table);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String... args) {
        Application.launch(args);
    }

    private List<Item> loadData() {
        List<Item> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Item item = new Item("item" + i, i);
            list.add(item);

        }
        return list;
    }

    private class TableCel_Edit extends TableCell<Item, String> {

        ChoiceBox<String> buySellBox = new ChoiceBox<>();

        public TableCel_Edit() {
            buySellBox.getItems().addAll("Buy", "Sell");
            buySellBox.getSelectionModel().selectedIndexProperty().addListener((obs, oldValue, newValue) -> {

                String value = buySellBox.getItems().get(newValue.intValue());
                processEdit(value);
            });

        }

        private void processEdit(String value) {
            commitEdit(value);
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText(getItem());
            setGraphic(null);
        }

        @Override
        public void commitEdit(String value) {
            super.commitEdit(value);
            // ((Item) this.getTableRow().getItem()).setName(value);
            setGraphic(null);
        }

        @Override
        public void startEdit() {
            super.startEdit();
            String value = getItem();
            if (value != null) {
                setGraphic(buySellBox);
                setText(null);
            }
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (item == null || empty) {
                setText(null);

            } else {
                setText(item);
            }
        }

    }

}