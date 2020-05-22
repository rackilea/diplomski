public class KeyStroke extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        TextField textField = new TextField("Itachi");
        textField.setDisable(true);
        textField.setStyle("-fx-opacity: 1.0;");
        root.getChildren().add(textField);
        Scene scene = new Scene(root, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}