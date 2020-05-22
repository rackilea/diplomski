public void onLogin(View view){
  String username = usernameEt.getText().toString();
    String password = passwordEt.getText().toString();
    String[] params = {"Login","username","password"};

    BackgroundWorker backgroundWorker = new BackgroundWorker(this);
    backgroundWorker.execute(params,"");

}