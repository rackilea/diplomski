// save data to firebase
     DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
                DatabaseReference ezzeearnRef = rootRef.child("UserId");
                ValueEventListener eventListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(android_id).exists()) {
                            //show what u want
                        } else {
                            //creating a new user
                            firebaseAuth.createUserWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            //checking if success
                                            if (task.isSuccessful()) {
                                                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

                                                rootRef.child("UserId").child(android_id).setValue(0);

                                                finish();
                                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                                            } else {
                                                //display some message here
                                                Toast.makeText(MainActivity.this, "Registration Error", Toast.LENGTH_LONG).show();
                                            }
                                            progressDialog.dismiss();
                                        }
                                    });
                        }