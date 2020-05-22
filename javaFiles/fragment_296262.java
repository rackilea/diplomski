messagesRef.addValueEventListener(new ValueEventListener() {
    public void onDataChange(DataSnapshot snapshot) {
        for (DataSnapshot child: snapshot.getChildren()) {
            ChatData data = child.getValue(ChatData.class);
        }
    }
    public void onCancelled(FirebaseError firebaseError) {
    }
}