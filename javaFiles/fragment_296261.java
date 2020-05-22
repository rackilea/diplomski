Firebase messagesRef = new Firebase("https://yours.firebaseio.com/messages");
messagesRef.addValueEventListener(new ValueEventListener() {
    public void onDataChange(DataSnapshot snapshot) {
        ChatData data = snapshot.getValue(ChatData.class);
    }
    public void onCancelled(FirebaseError firebaseError) {
    }
}