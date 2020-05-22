@Override
public void start(Stage primaryStage) throws Exception {
    TableView<String> tableView = new TableView<>();
    TableColumn<String, Object> x = new TableColumn<>("x");
    tableView.getColumns().add(x);
    TableColumn<String, Object> y = new TableColumn<>("");
    tableView.getColumns().add(y);

    x.setSortable(false);
    y.setSortable(false);

    makeHeader(x, "X", 0);
    makeHeader(y, "Y", 1);

    EventHandler<? super MouseEvent> handler = event -> {
        System.out.println("Column clicked " + ((Node)event.getTarget()).getProperties().get("index"));
    };
    x.getGraphic().addEventFilter(MouseEvent.MOUSE_CLICKED, handler);
    y.getGraphic().addEventFilter(MouseEvent.MOUSE_CLICKED, handler);
    primaryStage.setScene(new Scene(tableView));
    primaryStage.show();
}

private void makeHeader(TableColumn<?, ?> target, String name, int index) {
    VBox vBox = new VBox(new Label(name));
    vBox.setAlignment(Pos.CENTER);
    vBox.getProperties().put("index", index);
    target.setGraphic(vBox);
    target.setText("");
}