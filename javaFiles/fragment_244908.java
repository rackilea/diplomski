DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.orderByChild("foodname").equalTo("Burger");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        int count = 0;
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String foodqty = ds.child("foodqty").getValue(String.class);
            count = count + Integer.valueOf(foodqty);

        }
        Log.d(TAG, "count:" + count);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
query.addListenerForSingleValueEvent(valueEventListener);