@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case android.R.id.home:
            // Do stuff
            return true;
        case R.id.menu_item_2:
            // Do stuff
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}