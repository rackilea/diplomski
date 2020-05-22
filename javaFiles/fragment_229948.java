firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            //start profile activity
            finish();
            startActivity(new Intent(getApplicationContext(),RemoteControl.class));
        }

      else if(task.getException() instanceof 
             FirebaseAuthInvalidCredentialsException){
        Toast.makeText(context, "wrong password", Toast.LENGTH_SHORT).show();
    }else if(task.getException() instanceof FirebaseAuthInvalidUserException){
        Toast.makeText(context, "no user with such email", Toast.LENGTH_SHORT).show();
    }
    }
});