@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case android.R.id.home:
            //listen to back arrow in app bar
            finish();
            return true;

        default:
            return super.onOptionsItemSelected(item);
    }
}