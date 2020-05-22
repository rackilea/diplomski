public class MyApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        DB db = new DB();

        if (db.select("foo", "foopassword")) {
            Parent parent = FXMLLoader.load(getClass().getResource("/view/gameMenu.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}