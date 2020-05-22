DatabaseReference uidRef = usersRef.child(uid);
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()) {
            String userName = dataSnapshot.child("userName").getValue(String.class);
            nombre.setText(userName);
            Log.d("TAG", userName);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
uidRef.addListenerForSingleValueEvent(eventListener);