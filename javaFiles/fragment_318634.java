final ArrayAdapter<Item> itemAdapter = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, Item.itemArrayList);
ListView itemListView = (ListView) findViewById(R.id.itemListView);
itemListView.setAdapter(itemAdapter);

itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Item itemPicked = itemAdapter.getItem(i);
        IF STATEMENT GOES HERE;
    }
});