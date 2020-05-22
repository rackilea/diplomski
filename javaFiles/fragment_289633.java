auth.createUserWithEmailAndPassword(email, password)
  .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        Toast.makeText(SignupActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
        if (!task.isSuccessful()) {
            Toast.makeText(SignupActivity.this, "Authentication failed." + task.getException(), Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(SignupActivity.this, MainActivity.class));
            finish();
        }
    }
});