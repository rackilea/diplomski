private final TextField textField;

private final Symbol top, right, bottom, left;
private final Rectangle clip;

public GreaterCell(String number, Symbol top, Symbol right, Symbol bottom, Symbol left) {
    ...
    textField = new TextField();
    textField.setVisible(false);

    getChildren().addAll(path, textField, text);

    setOnMouseClicked(e -> {
        if (e.getClickCount() == 2) {
            text.setVisible(false);
            textField.setText(text.getText());
            textField.setVisible(true);
            textField.requestFocus();
        }
    });

    textField.setOnAction(e -> {
       textField.setVisible(false);
       text.setVisible(true);
       text.setText(textField.getText());
    });

    textField.focusedProperty().addListener((obs, ov, nv) -> {
        if (! nv) {
            textField.setVisible(false);
            text.setVisible(true);
        }
    });

}

@Override
protected void layoutChildren() {
    super.layoutChildren();

    ...
    textField.resizeRelocate(SIDE / 4d, SIDE / 4d, SIDE / 2d, SIDE / 2d);
}