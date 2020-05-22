DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference additionalUserInfoRef = rootRef.child("AdditionalUserInfo");
Query userQuery = additionalUserInfoRef.orderByChild("username").equalTo("Raxor2k");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Map<String, Object> map = new HashMap<>();
            map.put("user-age", "30");
            map.put("user-weight", "30");
            ds.getRef().updateChildren(map);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
userQuery.addListenerForSingleValueEvent(valueEventListener);