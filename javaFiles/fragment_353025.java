package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
@FXML
Label label;

//setter
public void setLabel(String labelText){
    label.setText(labelText);
}

//getter for label
public Label getLabel() {
    return label;
}

@Override
public void initialize(URL location, ResourceBundle resources) {
 }
}