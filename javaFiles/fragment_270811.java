mUserDatabase = FirebaseDatabase.getInstance().getReference("Cart");
mUserDatabase.addValueEventListener(new ValueEventListener() {

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
            Users_get post = childSnapshot.getValue(Users_get.class);
            System.out.println("DATAAAA: " + post);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + databaseError.getCode());
    }
});