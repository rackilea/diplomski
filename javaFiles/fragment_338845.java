package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PersonEditorController {
    private Database db = Database.getInstance();
    private DepartmentController departmentController;

    @FXML
    public Button saveButton;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;

    public void initialize() {
        saveButton.setOnAction(event ->
                db.savePerson(
                        departmentController.getDepartmentName(),
                        firstName.getText(),
                        lastName.getText()
                )
        );
    }

    public void setDepartmentController(DepartmentController departmentController) {
        this.departmentController = departmentController;
    }
}