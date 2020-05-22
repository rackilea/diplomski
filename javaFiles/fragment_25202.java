package com.mycompany.testing;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class FXMLDocumentController {

    @FXML
    private Label labelTest;

    @FXML
    private void closeLabelPressed(MouseEvent event) {
        Platform.exit();
    }
}