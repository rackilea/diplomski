package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    // Will be injected by FXMLLoader
    @FXML private TextField startField;
    @FXML private TextField lengthField;

    @FXML
    private void handleCompute(ActionEvent event) {
        event.consume();

        // Omitted error handling. If there was an exception one option is to
        // show a javafx.scene.control.Alert to the user.
        int start = Integer.parseInt(startField.getText());
        int length = Integer.parseInt(lengthField.getText());

        // Needs to be defined. Do something with result?
        fibonacci(start, length);
    }

}