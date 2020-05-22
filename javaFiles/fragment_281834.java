ref = FirebaseDatabase.getInstance().getReference().child("user_id").child("ASSETS");

ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String value = dataSnapshot.child("Stock").child("house").child("values").getValue(String.class);
        Log.d(TAG, "onChildAdded: the value is: "+value);

        if (dataSnapshot.child("Cash at bank").exists()) {
            String value = dataSnapshot.child("Cash at bank").getValue(String.class);
            Log.d(TAG, "onChildAdded: the cash at bank is: "+value);
        }
    }
    // ...
});