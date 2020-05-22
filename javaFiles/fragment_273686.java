...
       for (DataSnapshot snap : dataSnapshot.getChildren()) {
                                        ChatMessage chatMessage = snap.getValue(ChatMessage.class);
                                        mMessagesList.add(chatMessage);

                                    }

          populateMessagesRecyclerView();

    }
...