mPasswordTextWatcher = new InputValidator(mPassword);
mUserNameTextWatcher = new InputValidator(mUsername);

// Called when user type in EditText
mUsername.addTextChangedListener(mUserNameTextWatcher);
mPassword.addTextChangedListener(mPasswordTextWatcher);