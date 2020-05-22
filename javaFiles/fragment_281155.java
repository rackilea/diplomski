public class MyApplication extends Application {

    private boolean loggedIn ;

    @Override
    public void start(Stage ignored) {
        loggedIn = checkLoginFromDisk();
        while (! loggedIn) {
            LoginStage login = new LoginStage();
            loginStage.showAndWait();
            loggedIn = loginStage.checkLogin();
        }
        new MainStage().show();
    }

    // ...
}