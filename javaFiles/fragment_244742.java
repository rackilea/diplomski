public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot chatSnapshot: dataSnapshot.getChildren()) {
        String message = (String) chatSnapshot.child("message").getValue();
        String sender = (String) chatSnapshot.child("sender").getValue();
    }
}