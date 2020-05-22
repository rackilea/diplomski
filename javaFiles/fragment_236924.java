signup.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
    progressBar.setVisibility(View.VISIBLE);
    String emailStr = email.getText().toString()
     String password = password.getText().toString()
      if(emailStr == null || emailStr.isEmpty()){
            Toast.makeText("Email must not be empty", Toast.LENGTH_SHORT).show();
      }else if(password == null || password.isEmpty(){
              Toast.makeText("Password must not be empty", Toast.LENGTH_SHORT).show();
      }else{
              firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressBar.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                firebaseAuth.getCurrentUser().sendEmailVerification()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(MainActivity.this, "Registered successfully. Please check your email for verification",
                                                            Toast.LENGTH_LONG).show();
                                                    email.setText("");
                                                    password.setText("");
                                                } else {
                                                    Toast.makeText(MainActivity.this, task.getException().getMessage(),
                                                            Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });

                            }
                        }
                    });
            }
        }

});