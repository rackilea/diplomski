ListView listView = getListView();

    listView.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
            // Do your Staff Here 

          Intent intent = new Intent(MainActivity.this, Result.class);
          startActivity(intent);
        }
    });