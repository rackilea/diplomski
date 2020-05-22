private void showSub(boolean flag) {

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    Menu navMenu = navigationView.getMenu();
    if (!flag) {
        navMenu.findItem(R.id.nav_start).setVisible(false);
        navMenu.findItem(R.id.nav_delete).setVisible(false);
    } else {
        navMenu.findItem(R.id.nav_start).setVisible(true);
        navMenu.findItem(R.id.nav_delete).setVisible(true);
    }
}