package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    AlertController alertController = new AlertController();

    @FXML
    public Label mainLabel;

    @FXML
    public TextField mainTextField;

    @FXML
    public Button mainButton;

    @FXML
    public void onMainButtonClicked() {
        alertController.displayAlert();
        alertController.setAlertLabel("Hello from MainController!");
    }
}