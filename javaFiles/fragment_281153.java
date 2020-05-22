@Override
public void start(Stage primaryStage) {

    loggedIn = checkLoginFromDisk();

    while (! loggedIn) {
        LoginView loginView = new LoginView();
        Scene loginScene = new Scene(loginView.getView());
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Login");
        primaryStage.showAndWait();
        loggedIn = loginView.checkLogin();
    }
    MainView mainView = new MainView();
    Scene mainScene = new Scene(mainView.getView());
    primaryStage.setScene(mainScene);
    primaryStage.setTitle("My Application");
    primaryStage.sizeToScene();
    primaryStage.show();
}