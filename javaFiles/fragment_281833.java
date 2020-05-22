ref = FirebaseDatabase.getInstance().getReference().child("user_id").child("ASSETS").child("Stock");

ref.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        String value = dataSnapshot.child("house").child("values").getValue(String.class);
        Log.d(TAG, "onChildAdded: the value is: "+value);
    }
    // ...
});