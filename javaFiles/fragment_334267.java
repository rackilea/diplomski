@FXML
private TextField myTextField;


@FXML
private void initialize() {
    //Create a alpha field which max length of 4
    myTextField.setTextFormatter(new AlphaNumericTextFormatter(4));
}