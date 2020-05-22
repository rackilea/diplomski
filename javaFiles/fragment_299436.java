interface CustomDrawerListener extends DrawerLayout.DrawerListener{
    @Override
    void onDrawerSlide(View drawerView, float slideOffset);

    @Override
    default public void onDrawerOpened(View drawerView) {
    }

    @Override
    default public void onDrawerClosed(View drawerView) {

    }

    @Override
    default public void onDrawerStateChanged(int newState) {

    }
}