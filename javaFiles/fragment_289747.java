ref = new Firebase("https://my.firebaseio.com/messages").limitToLast(10);
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
            Message message = messageSnapshot.getValue(Message.class);
        }
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) { }
});