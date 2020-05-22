public void onDrawerClosed(View view) {
    getSupportActionBar().setTitle(mTitle);
    if (mNavigationItemClicked)
        selectNavigationItem();
    mNavigationItemClicked = false;
}