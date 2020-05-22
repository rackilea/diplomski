DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference electricianRef = rootRef.child("Employee").child("Electrician");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Electrician> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Electrician electrician = ds.getValue(Electrician.class);
            list.add(electrician);
            Log.d("TAG", electrician.getLname());
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {}
};
electricianRef.addListenerForSingleValueEvent(valueEventListener);