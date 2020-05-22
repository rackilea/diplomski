// Attach a listener to read the data at our posts reference
    login.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        FirebaseUser firebaseUser = dataSnapshot.getValue(Post.class);

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});