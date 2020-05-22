databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        ...
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        ...
    }
});