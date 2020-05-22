ListAdapter adapter = new ArrayAdapter<String>(this,R.layout.listword,R.id.wordView1, companies);

    ListView listView = (ListView) findViewById(R.id.secondListView1);

    listView.setAdapter(adapter);

    // Item Click listener

    listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> ok, View v, int position, long id){

          // Do your stuff here

        }
    });