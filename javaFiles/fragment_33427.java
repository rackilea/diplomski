public interface LoginListener {
    public void loginSucceeded(); // You want to return some information about the caller...
    public void loginFailed();
}

public class Application implements LoginListener {
    private Login login = null;
    public Application() {
        login = new Login(this);   
    }    
    public void loginSucceeded() {
        // Yea for me
    }
    public void loginFailed() {
        // Sucks for you
    }
}

public class Login extends JDialog {
    private LoginListener listener;
    public Login(LoginListener listener) {
       //...
    }

    public void processLogin() {
        if (loginSuccessful()) {
            listener.loginSucceeded();
        } else {
            listener.loginFailed();
        }
    }

}