saveButton.setOnAction(event ->
        db.savePerson(
                departmentController.getDepartmentName(),
                firstName.getText(),
                lastName.getText()
        )
);