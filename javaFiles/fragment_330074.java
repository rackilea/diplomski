Firebase ref = new Firebase("https://<yourapp>.firebaseio.com");
     ListAdapter adapter = new FirebaseListAdapter<ChatMessage>(this, ChatMessage.class, android.R.layout.two_line_list_item, mRef)
     {
         protected void populateView(View view, ChatMessage chatMessage)
         {
             ((TextView)view.findViewById(android.R.id.text1)).setText(chatMessage.getName());
             ((TextView)view.findViewById(android.R.id.text2)).setText(chatMessage.getMessage());
         }
     };
     listView.setListAdapter(adapter);