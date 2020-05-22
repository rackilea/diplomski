public class Main2 extends Application {

    private final double size = 400;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public final void start(Stage stage) throws IOException {
        AnchorPane pane = new AnchorPane();
        pane.setStyle("-fx-background-color: lightgray;");

        VBox root = new VBox(pane);
        VBox.setVgrow(pane, Priority.ALWAYS);
        root.setPadding(new Insets(10, 10, 10, 10));

        stage.setTitle("add none");
        stage.setScene(new Scene(root));
        stage.setWidth(size + 50);
        stage.setHeight(size + 70);

        draw(pane);
        stage.show();
//      stage.hide();
//      draw(pane);
//      stage.show();
    }

    private void draw(AnchorPane pane) {
        Rectangle big = new Rectangle(size, size);
        big.setFill(Color.RED.deriveColor(0, 1, 1, 0.3));
        big.setStroke(Color.RED);
        pane.getChildren().add(big);

        Rectangle small = new Rectangle(size/2, size/2);
        small.setFill(Color.BLUE.deriveColor(0, 1, 1, 0.3));
        small.setStroke(Color.BLUE);
        pane.getChildren().add(small);

        Shape subtract = Shape.subtract(big, small);
        subtract.setFill(Color.LIME.deriveColor(0, 1, 1, 0.3));
        subtract.setStroke(Color.LIME);

//      pane.getChildren().add(big);
//      pane.getChildren().add(small);
        pane.getChildren().add(subtract);
    }
}