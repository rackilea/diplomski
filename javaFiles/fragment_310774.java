try {
    String inputs = myTextBox.getText().toString();
    int i = Integer.parseInt(inputs);
    i++;
    outputTextBox.setText(String.valueOf(i));
} catch (NumberFormatException e) {
    // Invalid integer received (empty or null string)
    outputTextBox.setText("");
}