//Clear search bar
ImageView cancelClearSearch = findViewById(R.id.cancel_clear_search);
cancelClearSearch.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        this.productAdapter.getFilter().filter("");
        searchBar.setText("");
        searchBar.clearFocus();

        //Hide keyboard
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(searchBar.getWindowToken(), 0);

        //new DownloadProducts().execute(); no need to download data again
    }
});