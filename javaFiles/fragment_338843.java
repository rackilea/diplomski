package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class DepartmentController {
    @FXML
    private TextField departmentName;
    @FXML
    private RadioButton groupEditorControl;
    @FXML
    private VBox groupEditor;
    @FXML
    private GroupEditorController groupEditorController;
    @FXML
    private VBox personEditor;
    @FXML
    private PersonEditorController personEditorController;

    public void initialize() {
        groupEditor.setVisible(false);
        groupEditorControl.selectedProperty().addListener((observable, wasSelected, isSelected) -> {
            groupEditor.setVisible(isSelected);
            personEditor.setVisible(!isSelected);
        });

        groupEditorController.setDepartmentController(this);
        personEditorController.setDepartmentController(this);
    }

    public String getDepartmentName() {
        return departmentName.getText();
    }
}