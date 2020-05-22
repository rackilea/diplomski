Firebase firebaseRef = new Firebase("<Firebasae_URL>/Users").child("username");
firebaseRef.addListenerForSingleValueEvent(new ValueEventListener) {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()) {
            // User Exists
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
});