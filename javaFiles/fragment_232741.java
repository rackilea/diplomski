public void checkIfUserDataExists(){

        if(mAuth.getCurrentUser() != null) {

            userID = mAuth.getCurrentUser().getUid();
            myRef = FirebaseDatabase.getInstance().getReference().child("user_profile_info").child(userID);

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    Log.i("snapshot data", "dataSnapshot.getValue() = " + dataSnapshot.getValue());

                    if ((dataSnapshot.getValue() != null) && !dataSnapshot.getValue().toString().isEmpty() && !dataSnapshot.getValue().toString().equals("")) {

                        Intent intent = new Intent(SignInActivity.this, MenuActivity.class);
                        startActivity(intent);

                    } else {

                        Intent intent = new Intent(SignInActivity.this, ProfileActivity.class);
                        startActivity(intent);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }