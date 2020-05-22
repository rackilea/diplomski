public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_home) {
        MainActivity.FRAGMENT_TO_BE_LOADED = 3; 
        finish();
    }
}