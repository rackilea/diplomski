listView.setOnItemClickListener(new OnItemClickListener() {
   @Override
   public void onItemClick(AdapterView<?> listView, View view, 
     int position, long id) {
   // Get the cursor, positioned to the corresponding row in the result set
   Cursor cursor = (Cursor) listView.getItemAtPosition(position);

   // Get the state's capital from this row in the database.
   String countryCode = 
    cursor.getString(cursor.getColumnIndexOrThrow("code"));
   Toast.makeText(getApplicationContext(),
     countryCode, Toast.LENGTH_SHORT).show();

   }
});