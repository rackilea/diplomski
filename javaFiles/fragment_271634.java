package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;

public class MainController {
    @FXML
    private CheckBox showTextFields ;
    @FXML
    private StackPane display ;

    private Node radioDisplay ;
    private Node textFieldDisplay ;

    private RadioButtonController radioButtonController ;
    private TextFieldController textFieldController ;

    public void initialize() throws Exception {

        FXMLLoader radioDisplayLoader = new FXMLLoader(getClass().getResource("RadioDisplay.fxml"));
        radioDisplay = radioDisplayLoader.load();
        radioButtonController = radioDisplayLoader.getController();

        FXMLLoader textFieldDisplayLoader = new FXMLLoader(getClass().getResource("TextFieldDisplay.fxml"));
        textFieldDisplay = textFieldDisplayLoader.load();
        textFieldController = textFieldDisplayLoader.getController();

        showTextFields.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            if (isSelected) {
                display.getChildren().setAll(textFieldDisplay);
            } else {
                display.getChildren().setAll(radioDisplay);
            }
        });

        display.getChildren().add(radioDisplay);
    }

    @FXML
    private void submit() {
        if (showTextFields.isSelected()) {
            System.out.println("Value 1 is "+ textFieldController.getText1());
            System.out.println("Value 2 is "+ textFieldController.getText2());
        } else {
            System.out.println("Chosen value is "+radioButtonController.getSelectedItem());
        }
    }
}