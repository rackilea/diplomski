Firebase rootRef = new Firebase("https://<url>.firebaseio.com/users/");
Firebase userRef = rootRef.child(mAuthData.getUid() + "/");

userRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()) {

            // User exists. Do nothing

        } else addUser();

    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {}
});