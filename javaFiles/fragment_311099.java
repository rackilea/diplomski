public interface LoginView {

    public CredentialsView getCredentialsView();

    public void willAuthenticate();
    public void authenticationFailed();
    public void authenticationSucceeded();

    public void dismissView();

    public LoginViewController getLoginViewController();

}

public interface LoginViewController {

    public void authenticationWasRequested(LoginView view);
    public void loginWasCancelled(LoginView view);

}