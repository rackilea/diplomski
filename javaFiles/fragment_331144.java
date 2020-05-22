textField.setOnAction(event -> {
    commitEdit(textField.getText());
    event.consume();
}
textField.setOnKeyPressed(event -> {
    if (event.getCode() == KeyCode.ESCAPE) {
        cancelEdit();
        event.consume();
    }
}