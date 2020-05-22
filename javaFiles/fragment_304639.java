public void displayCatList(String id, String name){                 
      //create new HashMap
    HashMap<String,String> map = new HashMap<String, String>();

    //add each child node to HashMap key
    //map.put(TAG_ID, id);
    map.put(TAG_NAME, name);

    //adding HashList to ArrarList
    directoryList.add(map);

    MySimpleAdapter adapter = new MySimpleAdapter(this, R.layout.list_item, android.R.id.text1, directoryList);
    setListAdapter(adapter);

    adapter.notifyDataSetChanged();
}