public void actionPerformed(ActionEvent e){
    // example
    String someTextFieldInput = someTextField.getText();

    // if they are numbers from the field, you must parse
    // example
    int someInt = Integer.parseInt(someTextField.getText();

    // after you get all your input from the text fields, add them to labels
    someLabel.setText(someTextFieldInput);
    someOtherLabel.setText(String.valueOf(someInt));

}