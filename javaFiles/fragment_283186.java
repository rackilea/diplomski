private void validate(CheckBox checkBox, Person item, Event event){
    // Validate here
    event.consume();

    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Dialog");
    alert.setHeaderText("Look, a Confirmation Dialog");
    alert.setContentText("Are you ok with this?");

    // Set the checkbox if the user want to continue
    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == ButtonType.OK)
        checkBox.setSelected(!checkBox.isSelected());
}