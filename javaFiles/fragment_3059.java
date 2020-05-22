public class MainApp extends Application {

    private final Model = new Model();

    @Override
    public void start(Stage primaryStage) {
        // ...
    }

    public void firstStage() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/stage1.fxml"));
            rootLayout = (BorderPane) loader.load();

            Stage1Controller controller = loader.getController();
            controller.setModel(model);

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void secondStage() {

        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/stage2.fxml"));
            XD = (AnchorPane) loader.load();

            Stage2Controller controller = loader.getController();
            controller.setModel(model);

            // Show the scene containing the root layout.
            Scene scene = new Scene(XD);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}