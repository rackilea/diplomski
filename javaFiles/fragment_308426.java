setContentView(R.layout.activity_list_view_android_example);

// Get ListView object from xml
 listView = (ListView) findViewById(R.id.list);

//Create an arraylist populated with your values here
//then pass them into an adapter

 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
 android.R.layout.simple_list_item_1, android.R.id.text1, values);
 listView.setAdapter(adapter);