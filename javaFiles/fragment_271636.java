package application;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class RadioButtonController {
    @FXML
    private RadioButton choice1 ;
    @FXML
    private RadioButton choice2 ;

    public void initialize() {

        ToggleGroup toggleGroup = new ToggleGroup();
        choice1.setToggleGroup(toggleGroup);
        choice2.setToggleGroup(toggleGroup);
    }

    public String getSelectedItem() {
        if (choice1.isSelected()) {
            return "Choice 1";
        } else if (choice2.isSelected()) {
            return "Choice 2";
        } else return "" ;
    }
}