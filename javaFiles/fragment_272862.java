DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("test1");
reference.child("name").addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String name = dataSnapshot.getValue(String.class);
        Log.d("TAG", name);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) { throw databaseError.toException(); }
});