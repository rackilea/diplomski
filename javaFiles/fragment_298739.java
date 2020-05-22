ListView lv = getListView();
   lv.setOnItemClickListener(new OnItemClickListener()
   {
      @Override
      public void onItemClick(AdapterView<?> adapter, View view, int position,
            long arg3) 
      {
            String value = (String)adapter.getItemAtPosition(position); 

      }
   });