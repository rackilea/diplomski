ListView lv1;
  ArrayList<listItemWidgets_constr> image_details = new ArrayList<>();
  itemListAdapter adapter; 

  void onCreate(){
    ...
    lv1 = (ListView) findViewById(R.id.listView);
    adapter = new itemListAdapter(this, image_details);
    lv1.setOnItemClickListener(...);
  }

  public void itemListToListings(final itemRoot_api_constr spidy_iTN_construct) {
        image_details.clear();
        image_details.addAll(getListData(spidy_iTN_construct));
        adapter.notifyDataSetChanged();      
    }