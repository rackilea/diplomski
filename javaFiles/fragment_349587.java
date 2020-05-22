DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference hiscoreRef = rootRef.child("hiscore").child("player_name");
Query hiscoreQuery = hiscoreRef.orderByChild("score").limitToLast(1);
hiscoreQuery.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        int hiscore = 0;
        for (DataSnapshot ds: dataSnapshot.getChildren()) {
            hiscore = ds.child("score").getValue(Integer.class);
        }
        Log.d("TAG", String.valueOf(hiscore));
        ChangeMe.setText(hiscore);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        throw databaseError.toException(); // never ignore errors
    }

});