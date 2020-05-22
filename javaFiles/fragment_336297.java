databaseReference = FirebaseDatabase.getInstance().getReference().child("/userList/"+ FirebaseAuth.getInstance().getUid());
databaseReference.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
        Log.d(TAG, "onChildAdded: " + dataSnapshot.toString());
        Users users = dataSnapshot.getValue(Users.class);
        String firstName = users.getFirstName();
        String lastName = users.getLastName();
        Log.d(TAG, "onChildAdded: " + firstName + " " + lastName);
    }
}