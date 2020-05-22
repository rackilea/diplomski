public boolean CheckMissing() {
    boolean shouldProceed = true;
    EditText name = (EditText) findViewById(R.id.etName);
    if (name.getText().toString().isEmpty()) {
        name.setError("You need to enter name");
        shouldProceed = false;
    }
    EditText email = (EditText) findViewById(R.id.etEmail);
    if (email.getText().toString().isEmpty()) {
        email.setError("You need to enter Email");
        shouldProceed = false;
    }

    EditText mobile = (EditText) findViewById(R.id.etMobileNo);
    if (mobile.getText().toString().isEmpty()) {
        mobile.setError("You need to enter mobile");
        shouldProceed = false;
    }
    EditText password = (EditText) findViewById(R.id.etPassword);
    String Pass = password.getText().toString();
    if (password.getText().toString().isEmpty()) {
        password.setError("You need to enter password");
        shouldProceed = false;
    }
    EditText confirmpassword = (EditText) findViewById(R.id.etConfirmPassword);
    String Conpass = confirmpassword.getText().toString();
    if (confirmpassword.getText().toString().isEmpty()) {
        confirmpassword.setError("You need to enter confirmpassword");
        shouldProceed = false;
    }
    if (!Pass.equals(Conpass)) {
        confirmpassword.setError("Password Doesnt Match");
        shouldProceed = false;
    }

    return shouldProceed;
}