listView = (ListView) rootView.findViewById(android.R.id.list);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
       ... // body of your current onListItemClick() method
    }
});