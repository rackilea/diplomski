@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the searchView in which the query will be performed
        SearchView query = (SearchView) findViewById(R.id.search_button);
        query.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String url = GOOGLE_BOOKS_REQUEST_URL + query;
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                getLoaderManager().restartLoader(BOOK_LOADER_ID, bundle, BookListingActivity.this);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }