@Override
public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
        getSlidingMenu().showContent();
    }
    return false;
}