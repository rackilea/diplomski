package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TextFieldController {
    @FXML
    private TextField textField1 ;
    @FXML
    private TextField textField2 ;

    public String getText1() {
        return textField1.getText() ;
    }
    public String getText2() {
        return textField2.getText();
    }
}