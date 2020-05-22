@Override
public boolean onNavigationItemSelected(MenuItem item) {
    int id = item.getItemId();

    FragmentManager fragmentManager = getFragmentManager();
    PlaceholderFragment fragment;

    if (id == R.id.nav_camera) {
        // Handle the camera action
    } else if (id == R.id.nav_gallery) {
        fragment = new PlaceholderFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
  }
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
}
}