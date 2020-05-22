passwordTIL = (TextInputLayout) findViewById(R.id.input_layout_password);
passwordET = (EditText) findViewById(R.id.textVIew_password);


passwordET.addTextChangedListener(new SigninTextWatcher(passwordET)

//you can use this for username too or to check if the email format is correct or not.

private class SigninTextWatcher implements TextWatcher {
        private View view;

        private SigninTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.textView_password:
                    validatePassword();
                    break;
            }
        }
    }


    private boolean validatePassword() {
        if (passwordET.getText().toString().trim().isEmpty()) {
            passwordTIL.setError("Empty error message");
            requestFocus(passwordET);
            return false;
        } else if(passwordET.getText().toString().length() < 6){
                passwordTIL.setError("Short password error message");
                requestFocus(passwordET);
                return false;
        }else {
                passwordTIL.setErrorEnabled(false);
            }
            return true;
        }