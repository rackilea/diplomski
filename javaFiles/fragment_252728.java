package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    private final DataModel model ;

    @FXML
    private TextField userNameTextField ;

    public LoginController(DataModel model) {
        this.model = model ;
    }

    @FXML
    private void login() {
        model.setCurrentUser(new User(userNameTextField.getText()));
    }

}