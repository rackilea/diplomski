private void append_chat_conversation(DataSnapshot dataSnapshot) {
        ArrayList<Chat> chatList = new ArrayList<>();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            chatList.add(ds.getValue(Chat.class));
        }
        chatListAdapter adapter = new chatListAdapter(this, R.layout.chat_message, chatList);
        mListView.setAdapter(adapter);
}