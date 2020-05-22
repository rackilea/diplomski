SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, 
        android.R.layout.simple_list_item_1, 
        cur, 
        new String[] { Events.TITLE, [more fileds you want] }, 
        new int[] { android.R.id.text1 });

ListView listView = (ListView) findViewById(R.id.list);
listView.setAdapter(adapter);