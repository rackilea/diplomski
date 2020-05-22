ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
              android.R.layout.simple_list_item_1, android.R.id.text1, values);


// Assign adapter to ListView
listView.setAdapter(adapter);