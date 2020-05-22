do {
    if (Arrays.equals(PasswordField.getPassword(), ConfirmationField.getPassword()))
        MatchResult.setText("MATCH");
    else {
        MatchResult.setText("NO MATCH");
    }
}
while(!Arrays.equals(PasswordField.getPassword(), ConfirmationField.getPassword()));