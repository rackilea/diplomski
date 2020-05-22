@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu, menu);
    SearchView searchView = (SearchView) menu.findItem(R.id.options_menu_main_search).getActionView();
    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    if(null!=searchManager ) {
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
    }
}