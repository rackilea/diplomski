private void checkUsername(final String Username) {
        //Check early for the username length
        if (!TextUtils.isEmpty(Username) && Username.length() < 5) {
            DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
            final Query UsernameReference = mDatabaseReference.orderByChild("Username").equalTo(Username);
              UsernameReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String usernameExist = dataSnapshot.child("Username").getValue(String.class);

                //If the username not null
                if (usernameExist != null) {
                    //If username exist
                    if (usernameExist.equals(Username)) {
                        editTextUsername.setError("username taken");
                        editTextUsername.requestFocus();
                    } else {
                        //If not exist, proceed here, which mean success

                        //Change to your edit text
                        String email = null;
                        String password = null;
                        createAcc(email, password, Username);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    } else {
        editTextUsername.setError("Username too short");
        editTextSekolah.requestFocus();
    }
}

private void createAcc(final String email, String password, final String Username) {
    progressDialog.setMessage("Registering...");
    progressDialog.show();
    //creating a new user
    mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //checking if success
                    if (task.isSuccessful()) {

                        //Uid
                        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

                        User user = new User(
                                Username,
                                email);
                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(uid).setValue(user);
                        finish();
                        startActivity(new Intent(SignUpActivity.this, AgeDetailsActivity.class));

                    } else {
                        //display some message here
                        editTextEmail.setError("Email already exists");
                    }
                    progressDialog.dismiss();
                }
            });
}
}