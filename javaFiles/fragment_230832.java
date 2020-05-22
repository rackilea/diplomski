lv = (ListView) findViewById(R.id.list);
lv.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if( view.getId() == R.id.btnDetail ) {
               Intent maps = new Intent(MainActivity.this, MapsActivity.class);
               startActivity(maps);
            }
        }
    });