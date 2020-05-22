while (breakSwitch = true) {
    if (nameField.getText().isEmpty()) {
        errorReportField.setText("name error");
        break;
    }
    // stuff omitted
    if (e.getSource() == addVolumeButton) {
        // stuff omitted
        nameField.setText("");
        // stuff omitted
    }
    if (e.getSource() == addNumberButton) {
        // stuff omitted
        nameField.setText("");
        // stuff omitted
    }
    errorReportField.setText("");
}