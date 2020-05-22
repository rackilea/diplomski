package ui.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Model;

public class MenuController {

    private Model model ;

    @FXML
    private Button exitButton ;

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @FXML
    private void logout() {
        model.setLoggedIn(false);
    }

    @FXML
    private void someAction() {
        System.out.println("Some action....");
    }

    @FXML
    private void exit() {
        exitButton.getScene().getWindow().hide();
    }
}