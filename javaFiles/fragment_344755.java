loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameinput = usernameuser.getText().toString();
                passwordinput = passworduser.getText().toString();
                Users userlogin = db.userLogin(usernameinput);
                if (userlogin  != null && usernameinput.equals(userlogin.get_username()) && passwordinput.equals(userlogin.get_password())) {
                    startActivity(new Intent(getApplicationContext(), Home_Page.class));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

        });