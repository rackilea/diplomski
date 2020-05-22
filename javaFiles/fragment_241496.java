private void eseguiLogin(){
    Database.schema = Database.user = usernameTextField.getText();
    Database.password = new String(passwordField.getPassword());
    try{
        Database.setDefaultConnection(Database.connetti());
        premutoLogin = true;
        dispose();

        //this
        PrincipaleCF secondFrame = new PrincipaleCF();
    } catch(SQLException exc){
        PrincipaleCF.mostraErroriSwing(this, exc);
    }
}