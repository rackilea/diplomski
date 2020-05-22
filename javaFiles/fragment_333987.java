private void savetoParse() {

        ParseUser user = new ParseUser();
        user.setUsername(usernameEditText.getText().toString());
        user.setPassword(passEditText.getText().toString());
        user.put("name", nameEditText.getText().toString());
        user.setEmail(emailEditText.getText().toString());
        user.put("phone", phoneNoEditText.getText().toString());
        user.put("address", addressEditText.getText().toString());
        user.put("cityState", cityStateEditText.getText().toString());
        user.put("companyID", compSchoolIdEditText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {

            @Override
            public void done(ParseException e) {

                if (e != null) {

                    Toast.makeText(SignupActivityUpdate.this,
                            "Saving user failed.", Toast.LENGTH_SHORT).show();
                    Log.w(TAG,
                            "Error : " + e.getMessage() + ":::" + e.getCode());

                    if (e.getCode() == 202) {

                        Toast.makeText(
                                SignupActivityUpdate.this,
                                "Username already taken. \n Please choose another username.",
                                Toast.LENGTH_LONG).show();
                        usernameEditText.setText("");
                        passEditText.setText("");
                        confirmPassEditText.setText("");

                    }

                } else {

                    Toast.makeText(SignupActivityUpdate.this, "User Saved",
                            Toast.LENGTH_SHORT).show();

                    /*Do some things here if you want to.*/

                }

            }
        });