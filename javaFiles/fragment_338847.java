package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GroupEditorController {
    private Database db = Database.getInstance();
    private DepartmentController departmentController;

    @FXML
    private Button saveButton;
    @FXML
    private TextField groupName;
    @FXML
    private TextField groupDescription;

    public void initialize() {
        saveButton.setOnAction(event ->
                db.saveGroup(
                        departmentController.getDepartmentName(),
                        groupName.getText(),
                        groupDescription.getText()
                )
        );
    }

    public void setDepartmentController(DepartmentController departmentController) {
        this.departmentController = departmentController;
    }
}