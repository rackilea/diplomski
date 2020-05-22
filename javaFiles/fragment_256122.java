int secLevel;
try {
    secLevel = Integer.parseInt(secLvField.getText());
} catch (NumberFormatException nfe) {
    secLevel = -1; // If -1 is valid, pick some invalid value
}
if (secLevel == -1 || userField.getText().equals("") || passField.getText().equals("")) {
    notificationField.setText("All fields must be fullfiled.");
}
...