@Override
 public boolean onCreateOptionsMenu(Menu menu) {
     getMenuInflater().inflate(R.menu.menu, menu);

    MenuItem searchItem = menu.findItem(R.id.search_view);
    Button searchButton = searchItem.getActionView().findViewById(R.id.search_btn);
    searchButton.setOnClickListener(new OnClickListener() { // SEE HERE I'M GETTING    NullPointerException 
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, ((EditText)    findViewById(R.id.search_et)).getText().toString(), Toast.LENGTH_LONG).show();

        }
    });
   return true;
}