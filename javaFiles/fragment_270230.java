private void append_chat_conversation(DataSnapshot dataSnapshot) {

        chat_username = dataSnapshot.child("username").getValue(String.class);
        chat_msg = dataSnapshot.child("message").getValue(String.class);

        Chat chat = dataSnapshot.getValue(Chat.class);
        adapter.add(chat);
        Log.e("Chat username: ", "" + chat_username);
        Log.e("Chat message: ", "" + chat_msg);

    adapter.notifyDataSetChanged();
}