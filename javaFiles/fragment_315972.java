SQLiteDatabase database = openOrCreateDatabase("testdb.db",
                SQLiteDatabase.CREATE_IF_NECESSARY, null);

        String createTable = "CREATE TABLE IF NOT EXISTS " + "testtable" + "(" + "_id"
                + " integer primary key autoincrement, " + "serial1"
                + " text not null, " + "desc1" + " text not null, "
                + "id text);";

        String q = "SELECT id as _id,serial1,desc1 FROM testtable;";
        database.execSQL(createTable);
        for (int i = 0; i < 20; i++) {
            String serial = "serial - "+i;
            String desc = "desc - "+i;
            String id = "id - "+i;
            String sql =
                    "INSERT or replace INTO testtable (serial1, desc1, id)       VALUES('"+serial+"'"+",'"+desc+"'"+",'"+id+"')" ;       
                        database.execSQL(sql);
        }
        Cursor c = database.rawQuery(q, null);

        startManagingCursor(c);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.single_row_item_layout, c, new String[] { "serial1",
                        "desc1" }, new int[] { R.id.deviceSerial,
                        R.id.deviceDesc });
        ListView lv = (ListView) findViewById(R.id.deviceList);

        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        lv.setVisibility(View.VISIBLE);