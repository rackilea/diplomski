mAuth = FirebaseAuth.getInstance();
    mFirebaseDatabase = FirebaseDatabase.getInstance();
    myRef = mFirebaseDatabase.getReference();
    userID = mAuth.getCurrentUser().getUid();
    DatabaseReference testRef = myRef.child("user_preferences/"+userID);
    // or .child("user_preferences").child(userID)


    testRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            UserPreferences userPreferences = dataSnapshot.getValue(UserPreferences.class);
            Log.d(TAG, "onDataChange: " + userPreferences.getGender());

            // TODO: Update some UI element here
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            // TODO: Add error handling
        }
    });

}