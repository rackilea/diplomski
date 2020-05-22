searchItem = menu
.add(Menu.NONE, MENU_SEARCH, Menu.NONE, "Search")
.setIcon(android.R.drawable.ic_menu_search)
.setActionView(mSearchView)
.setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS
    | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);