comboBox.getEditor().focusedProperty().addListener(
    (observable, oldValue, newValue) -> {
        if (newValue) {
            // Select the content of the field when the field gets the focus.
            Platform.runLater(comboBox.getEditor()::selectAll);
        }
    }
);