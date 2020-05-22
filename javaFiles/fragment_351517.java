listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {
            Intent intent = new Intent(Dashboard.this, Dashboard_Description__page.class);
            intent.putExtra("key",YOUR_STRING);
            startActivity(intent);

        }
    });