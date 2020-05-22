NumberTextField numberTextField = new NumberTextField();
    numberTextField.setLayoutX(280);
    numberTextField.setLayoutY(280);
    // Textfield1 working
    numberTextField.focusedProperty().addListener((arg0, oldPropertyValue, newPropertyValue) -> {
        if (newPropertyValue) {

        } else {
            if (numberTextField.getText().isEmpty() || numberTextField.getText() == null
                    || Integer.parseInt(numberTextField.getText()) > 12) {
                numberTextField.setText("12");
            }
            System.out.println("Textfield 1 out focus");
        }

    });