login_btn.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(loginAttempts == 0) {

                    Toast.makeText(Mobile_Grocery.this, "Your attempt reach 0, please wait 3 minutes to log again", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (email.getText().toString().equals("admin") &&
                        password.getText().toString().equals("pass")) {
                    Toast.makeText(Mobile_Grocery.this, "Email and Password is correct",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent("com.example.admin.mobile_grocery.Method");
                    startActivity(intent);

                } else {

                    loginAttempts--;

                    Toast.makeText(Mobile_Grocery.this, "Email and Password is incorrect",
                            Toast.LENGTH_SHORT).show();

                    if(loginAttempts == 2) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            loginAttempts = 3;
                        }
                    }, WAIT_TIME);
                   }


                }

            }
        }
        );