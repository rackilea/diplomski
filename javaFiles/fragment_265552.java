@Override
public void start(Stage primaryStage) throws Exception {
    final int columns = 2;
    ColumnConstraints columnConstraints = new ColumnConstraints();
    columnConstraints.setPercentWidth(100d/columns);
    columnConstraints.setHalignment(HPos.CENTER);

    GridPane grid = new GridPane();

    for (int i = 0; i < columns; i++) {
        grid.getColumnConstraints().add(columnConstraints);
    }

    for (int i = 0; i < 100; i++) {
        grid.add(new Circle(50), i % columns, i / columns);
    }

    ScrollPane scrollPane = new ScrollPane(new VBox(grid));
    scrollPane.setFitToWidth(true); // make sure GridPane content resizes with viewport

    Scene scene = new Scene(scrollPane, 300, 300);
    primaryStage.setScene(scene);
    primaryStage.show();
}