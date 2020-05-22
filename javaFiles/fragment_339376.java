public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    switch (id) {
        case R.id.nav_new:
            subCreated = true;
            showSub(true);
            break;
...