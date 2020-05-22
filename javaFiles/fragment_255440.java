Log.d(TAG, "onCreateOptionsMenu " + hashCode());

super.onCreateOptionsMenu(menu, inflater);

inflater.inflate(R.menu.options_sign_browser, menu);
final MenuItem item = menu.findItem(R.id.action_toggle_starred);

if (this.showStarredOnly) {
    item.setIcon(R.drawable.ic_sign_browser_grade_checked);
} else {
    item.setIcon(R.drawable.ic_sign_browser_grade);
}

final SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);

final MenuItem searchItem = menu.findItem(R.id.action_search);

final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));