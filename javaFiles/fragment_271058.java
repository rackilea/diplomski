private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
    Log.d(GTAG, "firebaseAuthWithGoogle:" + acct.getId());
    AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
    mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(GTAG, "signInWithCredential:success");
                    user = mAuth.getCurrentUser();
                    updateUI(user);
                    Toast.makeText(this,"Please fill the remaining information ", Toast.LENGTH_LONG).show();
                    Intent register= new Intent(this, RegisterInfoActivity.class);
                    Log.d(LogTags.LOG_IN, "Here is the information passed. "+"firstName: "+firstName+"lastName: "+lastName+"email :"+email+"phoneNumber : "+phoneNumber+longitude);

                    register.putExtra("first_name", firstName);
                    register.putExtra("last_name", lastName);
                    register.putExtra("email", email);
                    register.putExtra("phoneNum", phoneNumber);
                    register.putExtra("latitude", latitude);
                    register.putExtra("longitude", longitude);

                    startActivity(register);

                   // Toast.makeText(RegisterInfoActivity.this,Gname+email+Gphone, Toast.LENGTH_LONG).show();
                } else {
                    // If sign in fails, display a message to the user.
                 //   Toast.makeText(RegisterInfoActivity.this, "Log In Failed",Toast.LENGTH_LONG).show();
                    Log.w(GTAG, "signInWithCredential:failure", task.getException());
                }
            });
}