DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference searchRef = rootRef.child("object").child("Search");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String value = ds.getValue(String.class);
            list.add(value);
        }
        Log.d("TAG", list.toString());
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
searchRef.addListenerForSingleValueEvent(valueEventListener);