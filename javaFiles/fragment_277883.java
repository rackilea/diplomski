public class ActivityName extends AppCompatActivity implements SearchView.OnQueryTextListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchview = new SearchView(this);
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchview.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        ...
        MenuItemCompat.setShowAsAction(item, 
                MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | 
                MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, searchview);
        searchview.setOnQueryTextListener(this);
        searchview.setIconifiedByDefault(false);

        return super.onCreateOptionsMenu(menu);
    }

    private void changeSearchViewTextColor(View view) { ... }

    @Override
    public boolean onQueryTextSubmit(String query) { return false; }

    @Override
    public boolean onQueryTextChange(String newText) {
        // update the observer here (aka nested fragments)
        return true;
    }
}