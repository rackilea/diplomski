messagesRef.addValueEventListener(new ValueEventListener() {
    public void onDataChange(DataSnapshot snapshot) {
        GenericTypeIndicator<Map<String,ChatData>> chatsType = new GenericTypeIndicator<Map<String,ChatData>>() {};
        Map<String,ChatData> chats = child.getValue(Map<String,ChatData>);
    }
    public void onCancelled(FirebaseError firebaseError) {
    }
}