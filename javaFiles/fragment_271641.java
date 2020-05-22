package application;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;

public class MainController {
    @FXML
    private CheckBox showTextFields ;
    @FXML
    private StackPane display ;

    @FXML
    private Node radioDisplay ;
    @FXML
    private Node textFieldDisplay ;

    @FXML
    private TextField textField1 ;
    @FXML
    private TextField textField2 ;
    @FXML
    private RadioButton choice1 ;
    @FXML
    private RadioButton choice2 ;

    public void initialize() throws Exception {

        showTextFields.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            if (isSelected) {
                display.getChildren().setAll(textFieldDisplay);
            } else {
                display.getChildren().setAll(radioDisplay);
            }
        });

        ToggleGroup toggleGroup = new ToggleGroup();
        choice1.setToggleGroup(toggleGroup);
        choice2.setToggleGroup(toggleGroup);
    }

    @FXML
    private void submit() {
        if (showTextFields.isSelected()) {
            System.out.println("Value 1 is "+ textField1.getText());
            System.out.println("Value 2 is "+ textField2.getText());
        } else {
            String chosenValue ;
            if (choice1.isSelected()) {
                chosenValue = "Choice 1";
            } else if (choice2.isSelected()) {
                chosenValue = "Choice 2";
            } else {
                chosenValue

 = "None";
            }

            System.out.println("Chosen value is "+chosenValue);
        }
    }
}