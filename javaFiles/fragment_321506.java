DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference ref = rootRef.child("Sreeauto");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            for(DataSnapshot dSnapshot : ds.getChildren()) {
                String date = dSnapshot.child("date").getValue(String.class);
                String incharge = dSnapshot.child("incharge").getValue(String.class);
                String qty = dSnapshot.child("qty").getValue(String.class);
                String shift = dSnapshot.child("shift").getValue(String.class);
                Log.d("TAG", date + " / " + incharge + " / " + qty + " / " + shift);

            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
ref.addListenerForSingleValueEvent(valueEventListener);