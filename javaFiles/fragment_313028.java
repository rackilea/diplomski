ListView yourListView = (ListView) findViewById(R.id.itemListView);

// get data from the table by the ListAdapter
 ListAdapter customAdapter = new ListAdapter(this, R.layout.itemlistrow, myList,  new ListInterFace () {
                    @Override
                      public void removeItem( int position) {
                      myList.remove(position);
                    customAdapter .notifyDataSetChanged();
                 });

 yourListView .setAdapter(customAdapter);