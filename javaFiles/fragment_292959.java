username.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        String username = dataSnapshot.getValue().toString();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});