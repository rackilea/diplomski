@Override
public boolean onOptionsItemSelected(MenuItem menu) {
    switch (menu.getItemId()) {
    case R.id.menu_refresh:
        // Stuff
    case R.id.menu_settings:
        showRefresh = false;
        //Stuff
    }
    return super.onOptionsItemSelected(menu);
}
@Override
public boolean onPrepareOptionsMenu(Menu menu) {
    menu.findItem(R.id.menu_refresh).setVisible(showRefresh);
    return super.onPrepareOptionsMenu(menu);
}