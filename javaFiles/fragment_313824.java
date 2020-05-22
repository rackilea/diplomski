package labeltext;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FXMLDocumentController {

    @FXML
    private Label lblTest;

    @FXML
    private void initialize() {
        lblTest.setText("I'm a Label.");
    }
}