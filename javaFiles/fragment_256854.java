@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
        case R.id.searchicon:
           //do something
            return true;
        case R.id.listicon:
              //do something
            return true;
        case R.id.gridicon:
              //do something
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}