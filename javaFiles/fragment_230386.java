@Override
public void start(Stage primaryStage) throws Exception {
    TableView<String> table = new TableView<String>();
    // Add rows
    for (int hour = 1; hour <= 24; hour++) {
        table.getItems().add(String.valueOf(hour));
    }
    TableColumn<String, String> tableColumn = new TableColumn<String, String>("Hours");
    // We only show Text
    tableColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
    table.getColumns().add(tableColumn);
    // Stretch column to tableViews width
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    // We create our own TableRows and listen on Clicks. You could also add
    // a listener to the tableViews selectionModel, but I like this way
    // more.
    table.setRowFactory(tableView -> {
        TableRow<String> row = new TableRow<String>();
        // If a row of our table is clicked...
        row.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
                // If not already applied we add a css-class defined 
                // in style.css.
                if (!row.getStyleClass().contains("marked")) {
                    row.getStyleClass().add("marked");
                }
                // ... 
            }
        });
        return row;
    });
    // The uninteresting stuff...
    Scene scene = new Scene(table, 50, 600);
    scene.getStylesheets()
            .add(getClass().getResource("/com/stackoverflow/marktablerows/style.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
}