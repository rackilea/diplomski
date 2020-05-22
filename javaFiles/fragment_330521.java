DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference attendanceRef = rootRef.child("Attendance");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String xname = ds.child("xname").getValue(String.class);
            Log.d(TAG, xname);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
attendanceRef.addListenerForSingleValueEvent(valueEventListener);