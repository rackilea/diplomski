MaterialSearchView searchView = (MaterialSearchView) findViewById(R.id.search_view);
searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            //Do some magic
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            //Do some magic
            return false;
        }
    });

    searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
        @Override
        public void onSearchViewShown() {
            //Do some magic
        }

        @Override
        public void onSearchViewClosed() {
            //Do some magic
        }
    });