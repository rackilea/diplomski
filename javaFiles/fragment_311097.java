public interface CredentialsView {

    public String getUserName();
    public char[] getPassword();

    public void willAuthenticate();
    public void authenticationFailed();
    public void authenticationSucceeded();

    public void setCredentialsViewController(CredentialsViewController listener);

}

public interface CredentialsViewController {

    public void credientialsDidChange(CredentialsView view);

}