DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference yourRef = rootRef.child("Subscription").child("Micro");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String name = dataSnapshot.child("name").getValue(String.class);
        String number = dataSnapshot.child("number").getValue(String.class);
        String price = dataSnapshot.child("price").getValue(String.class);
        Log.d("TAG", name + " / " + price + " / " + price);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
yourRef.addListenerForSingleValueEvent(eventListener);