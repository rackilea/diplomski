databaseReference.child("users").child(firebaseUserId).child("profile")
        .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Users users = snapshot.getValue(Users.class);

                    Toast.makeText(LoginActivity.this, "Name: " + users.getName() + "\n" +
                            "Gender: " + users.getGender(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });