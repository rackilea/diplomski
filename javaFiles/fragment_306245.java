private void initListView()
    {
        ListView listView = (ListView) findViewById(R.id.listView1);
        List<String> myDatalist = new ArrayList<>();
        ListViewAdapter listViewAdapter = new ListViewAdapter(myDatalist, R.layout.list_row_1); 
        listView.setAdapter(listViewAdapter);
    }