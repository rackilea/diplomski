public void listenerForAdvSearch()
{
    // Initialize advanced options button
    Button advancedOptionsBtn = (Button) findViewById(R.id.advancedButton);
    advancedOptionsBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
             Intent advancedOptions = new Intent(searchParam.this, advancedSearch.class);
             advancedOptions.putExtra("subject", selectedSubject);
             advancedOptions.putExtra("priceBand", priceBand);
             advancedOptions.putExtra("rating", starRating);
             advancedOptions.putExtra("isCheck", checked);
             startActivity(advancedOptions);
         }
     });
}