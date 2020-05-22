if(getSupportFragmentManager() != null){
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mNavigationDrawerFragment.setup(
                R.id.navigation_drawer,
                mNavigationDrawerItemList,
                mDrawerLayout
        );
    } else {
        Toast.makeText(getApplicationContext(), "getSupportFragmentManager is null", Toast.LENGTH_SHORT).show();
    }