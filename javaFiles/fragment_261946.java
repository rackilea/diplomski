list  = (ListView)findViewById(R.id.listView1);

list.setOnItemClickListener(new OnItemClickListener() {
    @Override
    //ListView parent, View v, int position, long id 
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        arg1.setBackgroundColor(Color.RED);
    }
});