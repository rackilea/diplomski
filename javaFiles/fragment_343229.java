package auto;


import javafx.fxml.FXML;

import javafx.scene.layout.GridPane;

public class FXMLDocumentController  {

    @FXML
    private GridPane Game;

    public void initialize() {
        for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
               Game.add(new Grass(), i, j);
           }
        }

    }

}