listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(YourActivity.this, YourNextActivity.class);
            // Insert your logic to send data based on which item was clicked here
            intent.putExtra("MY_EXTRA_DATA", "Some data!");

            startActivity(intent);
        }
});