DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference phoneNumberRef = rootRef.child("Employees").child(enteredPhoneNumber);
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if(dataSnapshot.exists()) {
            //do something
        } else {
            //do something else
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
phoneNumberRef.addListenerForSingleValueEvent(eventListener);