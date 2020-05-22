DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("goods").child("charger").orderByChild("productQuantity").equalTo(362);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            int productQuantity = ds.child("productQuantity").getValue(Integer.class);
            int newQuantity = productQuantity + 10;
            ds.child("productQuantity").getRef().setValue(newQuantity);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(valueEventListener);