public boolean onNavigationItemSelected(MenuItem item) {
    int id = item.getItemId();
    Fragment fragment=null;
    if (id == R.id.nav_camera) {

        Test   contactUsFragment=new Test();
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainLayout,contactUsFragment).commit();


    } else if (id == R.id.nav_gallery) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_conteiner, new Test(), "Test");
        transaction.commit();

    } else if (id == R.id.nav_slideshow) {

    }
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
}