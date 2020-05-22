btnsearch = (Button)findViewById(R.id.btnSearch); 
btnsearch.setOnClickListener(new View.OnClickListener() {

    public void onClick(View v) {

        Spinner spwhat = (Spinner) findViewById(R.id.spWhat);

        Intent ia = new Intent(SearchActivity.this, SearchResult.class);
        ia.putExtra("setwhat", spwhat.getSelectedItem().toString());
        startActivity(ia);
    }
});