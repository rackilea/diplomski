@Override
public void actionPerformed(ActionEvent e) {
    if (nameField.getText().isEmpty()) {
        errorReportField.setText("name error");
        return; // error occured; exit the method early
    }
    try {
        price = Integer.parseInt(priceField.getText());
    } catch (NumberFormatException exception) {
        errorReportField.setText("price error");
        priceField.setText("");
        return; // error occured; exit the method early
    }
    try {
        number = Integer.parseInt(numberField.getText());
    } catch (NumberFormatException exception) {
        errorReportField.setText("number error");
        numberField.setText("");
        return; // error occured; exit the method early
    }
    if (e.getSource() == addVolumeButton) {
        // omitted
    }
    if (e.getSource() == addNumberButton) {
        // omitted
    }
    errorReportField.setText("");
}