public class User {

    private final StringProperty login ; 

    public User(String login) {
        this.login = new SimpleStringProperty(login);
    }

    public StringProperty loginProperty() {
        return login ;
    }

    public final String getLogin() {
        return loginProperty().get();
    }

    public final void setLogin(String login) {
        loginProperty().set(login);
    }
}