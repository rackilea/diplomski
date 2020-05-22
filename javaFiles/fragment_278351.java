DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            long Coordinaat = ds.child("Coordinaat").getValue(Long.class);
            String Naam = ds.child("Naam").getValue(String.class);
            Log.d("TAG", Coordinaat + " / " + Naam);
            list.add(Coordinaat + " / " + Naam);
        }
        Log.d("TAG", list);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
rootRef.addListenerForSingleValueEvent(eventListener);