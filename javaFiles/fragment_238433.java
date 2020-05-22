DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference myCartRef = rootRef.child("myCart");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        int total = 0
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            int price = ds.child("price").getValue(Integer.class);
            total = total + price;
        }
        Log.d("TAG", "total = " + total);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
myCartRef.addListenerForSingleValueEvent(valueEventListener);