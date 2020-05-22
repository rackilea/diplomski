DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference sectionRef = rootRef.child("users").child("sec_a");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String name = ds.child("name").getValue(String.class);
            String rollno = ds.child("rollno").getValue(String.class);
            Log.d(TAG, name + " / " + rollno);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage());
    }
};
sectionRef.addListenerForSingleValueEvent(valueEventListener);