public void displayList() {
        final Cursor cursor = dbHelper.getData();
        String from[] = new String[]{DBHelper.LOCATION};
        int to[] = new int[]{R.id.ListLayout1};
        simpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.row_item, cursor, from, to, 0);


        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(simpleCursorAdapter);
        while (cursor.moveToNext()) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(cursor.getCount()>0) {
                    cursor.moveToPosition(i);
                    Intent intent = new Intent(MainActivity.this, EditData.class);
                    intent.putExtra("id", cursor.getInt(cursor.getColumnIndex(DBHelper._id)));
                    startActivity(intent);