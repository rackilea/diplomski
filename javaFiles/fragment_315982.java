public class MenuBox extends VBox {

@FXML
private LoginBox loginBox;

@FXML
private ProfilesBox profilesBox;

public MenuBox() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
        fxmlLoader.load();
    } catch (IOException exception) {
        throw new RuntimeException(exception);
    }
}

public class LoginBox extends VBox {
public LoginBox() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
        fxmlLoader.load();
    } catch (IOException exception) {
        throw new RuntimeException(exception);
    }
}

public class ProfilesBox extends VBox {
public ProfilesBox() {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("profiles.fxml"));
    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);
    try {
        fxmlLoader.load();
    } catch (IOException exception) {
        throw new RuntimeException(exception);
    }
}