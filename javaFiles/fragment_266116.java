public void listview(){
    String[] listcontent = {"Test1","text2","text4"};
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, getView().R.layout.listviewcontent, listcontent);
    ListView listView = (ListView) getView().findViewById(R.id.list);
    listView.setAdapter(adapter);
}

public void registerClickCallback() {
    ListView listView = (ListView) findViewById(R.id.list);
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView textView = (TextView) view;
            String message = "You clicked # " + position + " which is:" + textview.getText().toString();
            Toast.makeText(list.this, message, Toast.LENGTH_LONG).show();
        }
    });
}