number = PhoneNumber.getText().toString();
if (number != null) {
    sendVerification.setEnabled(true);
}
else {
    sendVerification.setEnabled(false);
}