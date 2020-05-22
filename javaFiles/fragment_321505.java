DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ref = rootRef.child("Sreeauto").child("28-05-2018");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String date = ds.child("date").getValue(String.class);
            String incharge = ds.child("incharge").getValue(String.class);
            String qty = ds.child("qty").getValue(String.class);
            String shift = ds.child("shift").getValue(String.class);
            Log.d("TAG", date + " / " + incharge + " / " + qty + " / " + shift);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
ref.addListenerForSingleValueEvent(valueEventListener);