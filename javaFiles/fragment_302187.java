DatabaseHandler db = new DatabaseHandler(this);
    db.getWritableDatabase();
    Cursor cur = db.getAllPersons();
    String[] columns = new String[]{"name", "budget"};
    int[] to = new int[]{R.id.name, R.id.budget};

    SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row_layout, cur, columns, to);
    final ListView listView = (ListView) findViewById(R.id.content_list);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {

            Intent intent = new Intent(MainActivity.this, PersonProfile.class);
            intent.putExtra("id", id);
            startActivity(intent);

        }
    });