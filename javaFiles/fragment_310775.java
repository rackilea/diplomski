if (TextUtils.isEmpty(inputs)) {
    outputTextBox.setText("");
} else {
    int i = Integer.parseInt(inputs);
    i++;
    outputTextBox.setText(String.valueOf(i));
}