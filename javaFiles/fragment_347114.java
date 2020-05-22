public class UserCredentials {

    private final String username;
    private final String password;

    public UserCredentials(String username, String password) {
        // maybe some validity checks
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}