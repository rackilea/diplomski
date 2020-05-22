@Override
 public boolean onMenuItemSelected(int featureId, MenuItem item) {

int itemId = item.getItemId();
switch (itemId) {
case android.R.id.home:
    toggle();

    // Toast.makeText(this, "home pressed", Toast.LENGTH_LONG).show();
    break;

}
return true;
}