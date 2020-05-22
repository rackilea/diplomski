@Override
public void start(Stage primaryStage) throws Exception {
    final double size = 50;

    ImageView pawn = new ImageView("https://upload.wikimedia.org/wikipedia/commons/9/93/Chess_tile_pd.png");
    pawn.setFitWidth(size);
    pawn.setFitHeight(size);

    final Background grey = new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY));
    final Background white = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));

    GridPane grid = new GridPane();
    ColumnConstraints columnConstraints = new ColumnConstraints(size);
    RowConstraints rowConstraints = new RowConstraints(size);
    for (int i = 0; i < 8; i++) {
        grid.getColumnConstraints().add(columnConstraints);
        grid.getRowConstraints().add(rowConstraints);

        for (int j = 0; j < 8; j++) {
            StackPane field = new StackPane();
            field.setBackground(((i + j) & 1) == 0 ? white : grey);
            grid.add(field, i, j);
            field.setOnMouseClicked(evt -> {
                if (pawn.getParent() != field) {
                    field.getChildren().add(pawn); // move pawn to this field on click
                }
            });
        }
    }

    ((Pane) grid.getChildren().get(0)).getChildren().add(pawn);

    Scene scene = new Scene(grid);

    primaryStage.setScene(scene);
    primaryStage.show();
}