public interface UserSigninViewListener {
    public void signupUser(UserSigninView view);
    public void authenticateUser(UserSigninView view);
}

public interface UserSigninView {
    public Pane getView();

    public String getName();
    public char[] getPassword();

    public void addUserSigninViewListener(UserSigninViewListener listener);
    public void removeUserSigninViewListener(UserSigninViewListener listener);

    public void userSignupFailed(Exception exp);
    public void userAuthenticationFailed(Exception exp);
}