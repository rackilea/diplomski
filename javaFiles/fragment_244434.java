lv.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                long id) {
             //YOUR ACTION HERE
             //or show a toast instead:
             Toast.makeText(ViewAllActivity.this, "Your message here", Toast.LENGTH_LONG).show();
        }
    });