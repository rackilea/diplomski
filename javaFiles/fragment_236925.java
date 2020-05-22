signup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
          progressBar.setVisibility(View.VISIBLE);
          String emailStr = email.getText().toString()
          String password = password.getText().toString()
          if(emailStr == null || emailStr.isEmpty()){
                Toast.makeText("Email must not be empty", Toast.LENGTH_SHORT).show();
                return;
          }

          if(password == null || password.isEmpty(){
                  Toast.makeText("Password must not be empty", Toast.LENGTH_SHORT).show();
                  return;
          }

          //the rest of the firebase code