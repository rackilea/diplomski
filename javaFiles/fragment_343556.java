query.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.hasChildren()) {
            for (DataSnapshot child : dataSnapshot.getChildren()) {
                emailcon.setText("email "+searchEmail+" found at URL "+child.getRef());
            }
        }
        else {
            emailcon.setText("still no email found!!");
        }
    }
    @Override
    public void onCancelled(FirebaseError firebaseError) {
    }
});