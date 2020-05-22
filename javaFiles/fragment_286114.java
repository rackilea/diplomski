userRef.child(username.getText().toString()).addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
    @Override
    public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
        System.out.println("Verifying Username");

        if (dataSnapshot.exists()){
            Toast.makeText(Signup.this, "Username doesn't exist", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException(); // don't ignore errors
    }
});