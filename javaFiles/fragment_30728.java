Cursor c = DB.rawQuery("SELECT * FROM " + TableName , null);
final ListView passList=(ListView)findViewById(R.id.passlist);
passList.setAdapter(new SimpleCursorAdapter(this, // Context
    android.R.layout.simple_list_item_1, // Layout
    c, // Your Cursor
    new String[] { "HOST" }, // Column(s) you want to display
    new int[] { android.R.id.text1 }),
    0); // Flags, 0 -> don't auto-requery when the data changes