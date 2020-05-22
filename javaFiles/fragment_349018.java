@Override
public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
switch (item.getItemId()) {
    case R.id.action_search:
    // search
    return true;
case R.id.action_settings:
    // settings
    return true;
default:
    return super.onOptionsItemSelected(item);
}
} // missing