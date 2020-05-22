ArrayList<String> listitem = new ArrayList<String>();
listitem.add("ABC");
listitem.add("DEF");

MyBaseAdapter baseAdapter = new  MyBaseAdapter(this,listitem);
ListView listView = (ListView) findViewById(R.id.list_view);
listView.setAdapter(baseAdapter);