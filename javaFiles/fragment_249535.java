package ui.login;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Model;

public class LoginController {
    private Model model ;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @FXML
    private TextField userField ;
    @FXML
    private PasswordField passwordField ;

    @FXML
    private void login() {
        String user = userField.getText() ;
        String password = passwordField.getText();
        // verify...
        model.setLoggedIn(true);
    }
}