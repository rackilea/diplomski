@SuppressWarnings("StatementWithEmptyBody")
@Override
public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_home) {
        //Home activity
    } else if (id == R.id.nav_call1) {
        //foo CallNumber(1);
    } else if (id == R.id.nav_call2) {
        //foo CallNumber(2);
    } else if (id == R.id.nav_call3) {
        //foo CallNumber(3);
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
}