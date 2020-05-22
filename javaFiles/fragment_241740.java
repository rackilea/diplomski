// Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);


    SearchManager searchManager=(SearchManager)getSystemService(Context.SEARCH_SERVICE);
    MenuItem item=menu.findItem(R.id.procura);

    searchView=(SearchView) MenuItemCompat.getActionView(item);
    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
    searchView.setQueryHint(getResources().getString(R.string.app_hint));


    return true;