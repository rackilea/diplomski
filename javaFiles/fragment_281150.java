public class MyApplication extends Application {

    private boolean loggedIn ;

    @Override
    public void start(Stage primaryStage) {

        loggedIn = checkLoginFromDisk();

        while (! loggedIn) {
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("path/to/login.fxml"));
            Parent loginRoot = loginLoader.load();
            LoginController loginController = loginLoader.getController();
            Scene loginScene = new Scene(loginRoot);
            primaryStage.setScene(loginScene);
            primaryStage.setTitle("Login");
            primaryStage.showAndWait();
            // check login from controller and update loggedIn...
        }

        FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("path/to/main.fxml"));
        Parent mainRoot = mainLoader.load();
        Scene mainScene = new Scene(mainRoot);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("My Application");
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    private boolean checkLoginFromDisk() {
        // ... etc
    }

    // for environments not supporting direct launch of JavaFX:
    public static void main(String[] args) {
        launch(args);
    }
}