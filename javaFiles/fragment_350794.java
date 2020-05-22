field2.editableProperty().bind(checkBox.selectedProperty());
checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
    if (isNowSelected) {
        field2.textProperty().unbind();
    } else {
        field2.textProperty().bind(field1.textProperty());
    }
});