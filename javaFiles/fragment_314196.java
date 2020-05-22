package application;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class SecondController implements Initializable {

    @FXML private Label labelField;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub  
    }

    public void setText(String name){
        this.labelField.setText(name);
    } 
}