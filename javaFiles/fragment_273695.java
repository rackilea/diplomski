public class Temp extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        Region rect = new Region();
        rect.setStyle("-fx-background-color: red; -fx-border-style: solid; -fx-border-width: 5; -fx-border-color: black; -fx-min-width: 20; -fx-min-height:20; -fx-max-width:20; -fx-max-height: 20;");
        root.getChildren().add(rect);

        Scene scene = new Scene(root, 100, 100);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}