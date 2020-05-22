public class Main extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
        final Alert alert = new Alert(Alert.AlertType.INFORMATION);

        primaryStage.setScene(new Scene(new Group(), 300, 300, Color.BLACK));

        alert.initOwner(primaryStage);

        alert.showAndWait();
    }

    public static void main(final String... args) {
        launch(args);
    }

}