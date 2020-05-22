@Override
        public void onClick(View view) {
            if (!email.getText().toString().equals("") && !password.getText().toString().equals("")) {
                showProgressBar();
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener((new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful() && task.getResult() != null){
                        hideProgressBar();
                        Toast.makeText(SignInActivity.this, "Signed In", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignInActivity.this, DashboardActivity.class);
                        startActivity(intent);
                        finish();
                      }
                    }
                })).addOnFailureListener((new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        hideProgressBar();
                        Toast.makeText(SignInActivity.this, "Failed to Sign In", Toast.LENGTH_SHORT).show();
                    }
                }));
            } else {
                Toast.makeText(SignInActivity.this, "please fill all fields", Toast.LENGTH_SHORT).show();
            }
        }
    }));