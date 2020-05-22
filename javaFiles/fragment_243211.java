// Add this property
MenuItem mSearchMenuItem;

public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putBoolean("isVisible", mSearchMenuItem.isVisible());
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main, menu);

    //setup SearchView and callbacks
    mSearchMenuItem = menu.findItem(R.id.action_search);
    if (mSavedInstanceState != null) {
        boolean isVisible = mSavedInstanceState.getBoolean("isVisible", true);
        mSearchMenuItem.setVisible(isVisible);
    }

    mSearchView = (SearchView) mSearchMenuItem.getActionView();
    mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return true;
        }

        @Override
        public boolean onQueryTextChange(String query) {
            // check whether this change is clearing all text from the search
            if (query.isEmpty()) {
                // close the searchView
                mSearchView.post(new Runnable() {
                    @Override
                    public void run() {
                        mSearchView.clearFocus();
                    }
                });
                mSearchView.setIconified(true);
            }
            return true;
        }
    });
    return true;
}