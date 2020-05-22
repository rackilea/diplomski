private Label screenLabel;
this.screenLabel = new Label();
this.screenLabel.setStyle("-fx-font: 40 arial");


private void buttonOnScreen(final Button button) {
    String text = this.screenText.getText();
    text += button.getText();

    this.screenLabel.setText(text);
}