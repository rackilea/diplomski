root.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        totalSize = (int) dataSnapshot.getChildrenCount();
    }


    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException(); // don't ignore errors
    }
});