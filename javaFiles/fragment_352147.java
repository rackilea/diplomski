divide.setOnAction(event -> buttonOnScreen(divide));

private void buttonOnScreen(final Button button) {
    Label label = new Label(button.getText());
    screen.getChildren().add(label);
    label.setStyle("-fx-font: 40 arial");
}