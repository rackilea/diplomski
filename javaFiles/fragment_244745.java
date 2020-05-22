query.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        Chat chat = dataSnapshot.getValue(Chat.class);
        String message = chat.getMessage();
        String sender = chat.getSender();
    }

    // other overridden messages have been removed for brevity

})