package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AlertController extends AnchorPane {
    Stage window;

    @FXML
    public Label alertLabel;

    @FXML
    Button alertButton;


    public AlertController() {
        window = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Alert.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
            Scene scene = new Scene(this);
            window.setScene(scene);
            window.setTitle("Alert");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayAlert() {
        window.show();
    }

    public void setAlertLabel(String str) {
        alertLabel.setText(str);
    }

    @FXML
    public void onAlertButtonClicked() {
        window.close();
    }
}