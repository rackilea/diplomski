do{
    if((PasswordField.getPassword())==(ConfirmationField.getPassword()));
    MatchResult.setText("MATCH");
}
else{
    MatchResult.setText("NO MATCH");
}
while((PasswordField.getPassword())!(ConfirmationField.getPassword()));