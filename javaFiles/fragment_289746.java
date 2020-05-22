ref = new Firebase("https://my.firebaseio.com/messages").limitToLast(10);
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
            String name = (String) messageSnapshot.child("name").getValue();
            String message = (String) messageSnapshot.child("message").getValue();
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) { }
});