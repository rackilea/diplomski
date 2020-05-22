public class MyApplication extends Application {

    private MainController mainController ;

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(...);
        Parent root = loader.load();
        mainController = loader.getController();

        // ...

    }

    @Override
    public void stop() {
        mainController.shutdown();
    }
}