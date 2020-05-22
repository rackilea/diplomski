MyDbHandler handler = new MyDbHandler(this,"quicklist.db",null,1);

  ListView  mylist = (ListView) findViewById(R.id.listView);
    mylist.setOnItemClickListener(
            new AdapterView.OnItemClickListener()
    {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
           Cursor cursor=handler.fetchAllData();
          cursor.moveToPosition(position);
           String _id=cursors.getString(cursor.getColumnIndex("_id"));
           Log.d("Clicked item id", " "+_id);

        }
});