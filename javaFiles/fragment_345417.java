DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference electricianRef = rootRef.child("Employee").child("Electrician");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String lName = ds.child("Lname").getValue(String.class);
            list.add(lName);
            Log.d("TAG", lName);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
};
electricianRef.addListenerForSingleValueEvent(valueEventListener);