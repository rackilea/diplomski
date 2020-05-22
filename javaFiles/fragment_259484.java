@Override public void onItemClick(AdapterView parent
                            , View view
                            , int position
                            , long id) {
    mPosition = position;
    mNavigationItemClicked = true;
    mDrawerLayout.closeDrawer(mDrawerList); 
}