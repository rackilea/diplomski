public class Sample extends Application {

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample/test.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root, 400, 200);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}