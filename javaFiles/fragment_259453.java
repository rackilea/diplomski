com.example.rory.dbtest.DBAdapter db = new com.example.rory.dbtest.DBAdapter(this);
    db.open();

ArrayList<String> data_list=new ArrayList<String>();
ListView lv=(ListView)findViewById(R.id.listView1);
Cursor c = db.getAllRecords();
    if (c.moveToFirst())
    {
        do {
            data_list.add(c.getString(0));
            DisplayRecord(c);
        } while (c.moveToNext());
    }
ArrayAdapter<String> aa=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, data_list);
        lv.setAdapter(aa);