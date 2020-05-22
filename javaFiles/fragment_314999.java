db = FirebaseDatabase.getInstance().getReference().child(auth.getCurrentUser().getUid());
db.addValueEventListener(new ValueEventListener() {
    public void onDataChange(DataSnapshot dataSnapshot) {
        user usr = s.getValue(user.class);
        Log.d("Value from : ",usr.getName());
    }
    public void onCancelled(DatabaseError databaseError) {
        Toast.makeText(getApplicationContext(), "yolo", Toast.LENGTH_LONG).show();
    }
});