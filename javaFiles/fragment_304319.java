@Override
public boolean onPrepareOptionsMenu(Menu menu) {
    // Enable disable set start page item
    if(!sharedPref.getBoolean("enable_custom_startpage", false)) {
        toolbar.getMenu().findItem(R.id.setasstartpage).setVisible(false);
    }

    return true;
}