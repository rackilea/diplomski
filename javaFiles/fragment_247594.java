package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.GridPane;

public class Controller {

    @FXML private GridPane grid;
    private CheckBox[][] boxes; // for access by grid coordinates

    @FXML
    private void initialize() {
        boxes = new CheckBox[16][16];
        for (int row = 0; row < boxes.length; row++) {
            for (int col = 0; col < boxes[0].length; col++) {
                CheckBox box = new CheckBox();
                grid.add(box, col, row);
                boxes[row][col] = box;
            }
        }
    }

}