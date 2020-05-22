String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference followingRef = rootRef.child("follows").child(uid).child("following");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String userId = ds.getKey();

            DatabaseReference userIdRef = rootRef.child("users").child(userId);
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot dSnapshot : dataSnapshot.getChildren()) {
                        String name = dSnapshot.child("name").getValue(String.class);
                        Log.d("TAG", name);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {}
            };
            userIdRef.addListenerForSingleValueEvent(eventListener);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
followingRef.addListenerForSingleValueEvent(valueEventListener);