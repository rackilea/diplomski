DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
Query query = rootRef.child("History").orderByChild("driver").equalsTo(driverId).limitToLast(1);
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String response = dataSnapshot.child("payment response").getValue(String.class);
            if(response.equalTo("approved")) {
                Log.d("TAG", "Payment approved!");
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
query.addListenerForSingleValueEvent(valueEventListener);