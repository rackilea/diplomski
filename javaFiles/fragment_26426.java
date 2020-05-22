DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference idRef = rootRef.child("History").child("-LIRZ4Nf2HyTTYtZEeOA");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String response = dataSnapshot.child("payment response").getValue(String.class);
        if(response.equalTo("approved")) {
            Log.d("TAG", "Payment approved!");
        } else {
            Log.d("TAG", "Payment not approved!");
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
idRef.addListenerForSingleValueEvent(valueEventListener);