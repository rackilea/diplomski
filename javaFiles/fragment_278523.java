baseAdapter = new MyBaseAdapter(context,listitem);

setTitle("Results Page");
setContentView(R.layout.activity_display_flights);
listView = (ListView) findViewById(R.id.list_view);
listView.setBackgroundResource(R.drawable.androidbckgrnd1);
listView.setAdapter(baseAdapter);