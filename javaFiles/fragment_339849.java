@Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        Message message = dataSnapshot.getValue(Message.class);
                        messageList.add(message);
                        instantiateRecyclerView();
                }
            }