@FXML
void initialize() {
    //String loginPsw = loginPassword.getText();
    //String loginName = loginUsername.getText().trim();

    loginBtn.setOnAction(actionEvent -> {
        if (loginUsername.getText().length() > 0 && loginUsername.getText().length > 0){
            loginFunction(loginUsername.getText().trim(), loginPassword.getText());
        }else {
            System.out.println("prova");
        }
    });

}

private void loginFunction(String loginUsername, String loginPassword) {
    System.out.println("sukses");
}