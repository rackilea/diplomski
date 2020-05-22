loginButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        emailText = (EditText) findViewById(R.id.emailText);
        passwordText = (EditText) findViewById(R.id.passwordText);

        String email = emailText.getText().toString();
        if (email.equals("meric.erler@metu.edu.tr")
                && passwordText.getText().toString().equals("meric1234")) {
            startData(email);
        } else {
            errorView.setText("Invalid E-mail or Password.");
        }
    }
});