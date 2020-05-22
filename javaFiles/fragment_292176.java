public interface UserAuthenticationistener {
    public void userAuthenticated(User user);
    public void userAuthenticationFailed(Exception exp); // Or some other error object
}

public interface UserAuthenticator {
    public void authenticateUser(String name, char[] password) throws SecurityException;

    public void addUserAuthenticator(UserAuthenticator listener);
    public void removeUserAuthenticator(UserAuthenticator listener);
}