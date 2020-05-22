public void onDataChange(DataSnapshot dataSnapshot) {
    for (DataSnapshot chatSnapshot: dataSnapshot.getChildren()) {
        Chat chat = chatSnapshot.getValue(Chat.class);
        String message = chat.getMessage();
        String sender = chat.getSender();
    }
}