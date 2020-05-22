public class User {

    private final String username;
    private final String password;
    private final boolean something;

    public User(String username, String password, boolean something) {
        this.username = username;
        this.password = password;
        this.something = something;
    }

    public boolean login() {
        return correctPassword && correctUsername
    }

    private boolean correctPassword() { }
    private boolean correctUsername() { }

    public Menu getMenu() {
        // Return User menu
    }
}


public class Admin extends User {

    public Admin(String username, String password, boolean something) {
        super(username, password, something);
    }

    @Override
    public boolean login() {
        final boolean isAuthenticated = super.login();
        final boolean isAuthorized = isAllowedToDoThis();
        return isAuthenticated && isAuthorized;
    }

    private boolean isAllowedToDoThis() { }

    @Override
    public Menu getMenu() {
        // Return Admin menu
    }
}