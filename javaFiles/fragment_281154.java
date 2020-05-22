public class LoginStage extends Stage {

    private final LoginView loginView ;
    public LoginStage() {
        loginView = new LoginView();
        setScene(new Scene(loginView.getView());
        setTitle("Login");
    }

    public boolean checkLogin() {
        return loginView.checkLogin(); 
    }
}