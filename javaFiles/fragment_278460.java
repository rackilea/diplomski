drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
    }

    @Override
    public void onDrawerOpened(View drawerView) {
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        if (mDrawerItemClicked){
            mDrawerItemClicked = false;

            toolbar.setTitle(getResources().getString(R.string.title));
            fragmentMain = new FragmentMain();
            android.app.FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                   .replace(R.id.frameLayoutMain, ApplicationTapaKiosk.getInstance().fragmentMain)
                   .commit();
        }
    }

    @Override
    public void onDrawerStateChanged(int newState) {
    }
});