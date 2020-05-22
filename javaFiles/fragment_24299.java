mref.child(RoomName).addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(DataSnapshot dataSnapshot) {
       list.clear();
    for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()) {
        ChatMessage value = dataSnapshot1.getValue(ChatMessage.class);
        ChatMessage fire = new ChatMessage();
        String msgtxt = value.getMessageText();
        String user=value.getMessageUser();
        long msgtime=value.getMessageTime();
        String  prothumb=value.getProfuri();
        String sentimguri=value.getSentimguri();
        String type=value.getType();

        fire.setMessageUser(user);
        fire.setMessageText(msgtxt);
        fire.setMessageTime(msgtime);
        fire.setProfuri(prothumb);
        fire.setSentimguri(sentimguri);
        fire.setType(type);
        list.add(fire);
    }

  if(!(recyclerView.canScrollVertically(1)))
            {
            recyclerView.smoothScrollToPosition(adapter.getItemCount());
            }

    adapter.notifyDataSetChanged();
    //layoutManager.setStackFromEnd(true);
}

//Initializing RecyclerView
private void initRecyclerView() {
    //Log.d(TAG, "initRecyclerView: init recyclerview.");
    recyclerView =(RecyclerView) findViewById(R.id.list_of_messages);
    recyclerView.setHasFixedSize(true);
    layoutManager=new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    //initialse your adapter only once 
    adapter = new RecyclerViewAdapter(ChatRoom.this, list);        
    recyclerView.setAdapter(adapter);
    layoutManager.setStackFromEnd(true);

    //recyclerView.scrollToPosition(list.size() - 1);
}