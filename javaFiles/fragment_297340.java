private Color color = Color.BLACK;

@Override
public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane(); 
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    Button btn = new Button("Add Rect");

    // add node specifying column and row index
    gridPane.add(btn, 0, 0);

    gridPane.setStyle("-fx-background-color: lime;");

    btn.setOnAction((ActionEvent event) -> {
        color = color.brighter();
        Rectangle rectangle = new Rectangle(20, 20);
        rectangle.setFill(color);

        // append rect to second row
        gridPane.addRow(1, rectangle);
    });

    Scene scene = new Scene(gridPane, 500, 500);

    primaryStage.setScene(scene);
    primaryStage.show();
}