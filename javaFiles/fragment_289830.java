private void firebaseAuthWithGoogle(GoogleSignInAccount account) {





    AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
    mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(SignInActivity.this,"Registration Is Succesfull",Toast.LENGTH_LONG).show();
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithCredential:success");

                        //getting current users account
                        FirebaseUser user=mAuth.getCurrentUser();

                        //getting the display name of the current user to store them in our real time database

                        final String databaseUserName=user.getDisplayName();


                        //creating a child called users
                        final DatabaseReference myRootRef = FirebaseDatabase.getInstance().getReference().child("Users");



                        //here we make a control such that, if logged in user is exist in the realtime database
                        //if not exists, then we save them , if exists we continue with the else statement and break it.
                        myRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(!dataSnapshot.hasChild(databaseUserName)){

                                    DatabaseReference userNameRef =  myRootRef.child(databaseUserName);
                                    //value is also set to user display name however it doenst have to be so
                                    userNameRef.setValue(databaseUserName);



                                } else{


                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });




                        //after that user is redirected to the main account activity.
                        Intent accountIntent = new Intent(SignInActivity.this,UserAccountActivity.class);
                        accountIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(accountIntent);


                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithCredential:failure", task.getException());
                        Toast.makeText(SignInActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();

                        // if signing up task is unsuccesfull we do make a error indication pretty much.
                        FirebaseAuthException e = (FirebaseAuthException )task.getException();
                        Toast.makeText(SignInActivity.this, "Failed Registration: "+e.getMessage(), Toast.LENGTH_SHORT).show();

                        Log.e("LoginActivity", "Failed Registration", e);

                    }


                }
            });



}