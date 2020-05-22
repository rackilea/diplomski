@Override
 public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    // convert Datasnapshot into a Message object

    Message mes = dataSnapshot.getValue(Message.class);

    // add it to an ArrayList of Message

    messageList.add(mes);  // notice the changes
    notifyDataSetChanged();

 }