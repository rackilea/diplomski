DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference usersRef = rootRef.child("users");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        long numberOfUsers = dataSnapshot.getChildrenCount(); // Count the number of users

        //This is called iteration
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            // Get user object on every iteration
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
};
usersRef.addListenerForSingleValueEvent(valueEventListener);