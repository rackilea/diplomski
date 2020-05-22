@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId) {
        case R.id.search:
            onSearchRequested();
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}