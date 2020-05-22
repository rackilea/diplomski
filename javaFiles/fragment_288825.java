public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    Fragment fragment=null;
    int id = item.getItemId();

    if (id == R.id.nav_home) {
        // Handle the camera action
        fragment = new HomeFragment();
    } else if (id == R.id.nav_points) {
      fragment = new PointFragment();
    } else if (id == R.id.nav_coupons) {
      fragment = new CouponFragment();
    } else if (id == R.id.nav_about) {
      fragment = new AboutFragment();
    }
    fragmentTransaction.replace(containerId, fragment,fragment.getClass().getSimpleName());
    fragmentTransaction.commit();
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
}