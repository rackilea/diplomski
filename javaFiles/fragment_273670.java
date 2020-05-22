@Override
public void cancelEdit() {
    super.cancelEdit();

    // Default value
    String val = "0.0";

    // Check to see if there's a value
    if (!textField.getText().equals(""))
        val = textField.getText();

    // Set table cell text
    setText("" + val);
    setGraphic(null);
}