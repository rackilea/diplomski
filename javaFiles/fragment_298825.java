public void userLogin() {
    String email = etEmail.getText().toString().trim();
    final String password = etPassword.getText().toString().trim();

    if(TextUtils.isEmpty(email)){
        //email is empty
        Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
        return ;
    }

    if(TextUtils.isEmpty(password)){
        //password is empty
        Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
        return ;
    }

    progressDialog.setMessage("Login Please wait...");
    progressDialog.show();

    firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    performTask(task);

                }
            });

}

public void performTask(Task<AuthResult> task) {



    if (task.isSuccessful()) {
        finish();
        userVerified();
    } else {
        String errorCode = ((FirebaseAuthException) task.getException()).getErrorCode();

        switch (errorCode) {

            case "ERROR_INVALID_EMAIL":
                Toast.makeText(Signin.this, "The email address is badly formatted.", Toast.LENGTH_LONG).show();
                etEmail.setError("The email address is badly formatted.");
                etEmail.requestFocus();
                break;

            case "ERROR_WRONG_PASSWORD":
                Toast.makeText(Signin.this, "The password is invalid ", Toast.LENGTH_LONG).show();
                etPassword.setError("password is incorrect ");
                etPassword.requestFocus();
                etPassword.setText("");
                break;

            case "ERROR_USER_MISMATCH":
                Toast.makeText(Signin.this, "The supplied credentials do not correspond to the previously signed in user.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_REQUIRES_RECENT_LOGIN":
                Toast.makeText(Signin.this, "This operation is sensitive and requires recent authentication. Log in again before retrying this request.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL":
                Toast.makeText(Signin.this, "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address.", Toast.LENGTH_LONG).show();
                break;

            case "ERROR_EMAIL_ALREADY_IN_USE":
                Toast.makeText(Signin.this, "The email address is already in use by another account.   ", Toast.LENGTH_LONG).show();
                etEmail.setError("The email address is already in use by another account.");
                etEmail.requestFocus();
                break;
            case "ERROR_USER_NOT_FOUND":
                Toast.makeText(Signin.this, "Your account not registered", Toast.LENGTH_LONG).show();
                break;
        }

        userLogin();
    }
}