package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    Button v1;
    @FXML
    Button v2;
    @FXML
    Button v3;

    public void printButton(ActionEvent event){

        Button sourceButton = (Button) event.getSource();

        if(sourceButton.equals(v1)){
            System.out.print("v1");
        }

        else if(sourceButton == v2){
            System.out.print("v2");
        }

        else if(sourceButton == v3){
            System.out.print("v3");
        }

    }
}