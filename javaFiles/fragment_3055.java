public class MainApp  extends Application {

    private Stage1Controller stage1Controller ;
    private Stage2Controller stage2Controller ;

    @Override
    public void start(Stage primaryStage) {
        firstStage();
        secondStage();

        stage1Controller.setStage2Controller(stage2Controller);

        // ...
    }

    public void firstStage() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/stage1.fxml"));
            rootLayout = (BorderPane) loader.load();

            stage1Controller = loader.getController();

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

            stage2Controller = loader.getController();

            // Show the scene containing the root layout.
            Scene scene = new Scene(XD);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ...
}