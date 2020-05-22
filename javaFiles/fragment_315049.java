SearchView searchView;
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate( R.menu.main, menu);

    MenuItem myActionMenuItem = menu.findItem( R.id.action_search);
    searchView = (SearchView) myActionMenuItem.getActionView();
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }
        @Override
        public boolean onQueryTextChange(String s) {
            EventBus.getDefault().post(new SearchQueryEvent(s));
            return false;
        }
    });
    return true;

}