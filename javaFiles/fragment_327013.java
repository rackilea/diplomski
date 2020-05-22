super.onCreate(savedInstanceState);
setContentView(R.layout.activity_chat_room);
    recView = (RecyclerView) findViewById(R.id.recyclerViewMessages);
    linearLayoutManager = new LinearLayoutManager(this) {};
    linearLayoutManager.setReverseLayout(true);
    recView.setLayoutManager(linearLayoutManager);
    // change here
    if (listData != null)
        listData.clear();
    else listData = new <> ArrayList();
    listData.addAdd((ArrayList)MessagingData.getMessageListData());
    adapter = new RecyclerViewAdapterMessaging(listData, this);
    recView.setAdapter(adapter);
    adapter.setItemClickCallback(this);
    final Handler h = new Handler();
    final int delay = 2000; //milliseconds