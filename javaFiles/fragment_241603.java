private void selectItem(int position,String id,String name) {
    mCurrentSelectedPosition = position;
    if (mDrawerListView != null) {
        mDrawerListView.setItemChecked(position, true);
    }
    if (mDrawerLayout != null) {
        mDrawerLayout.closeDrawer(mFragmentContainerView);
    }
    if (mCallbacks != null) {
        mCallbacks.onNavigationDrawerItemSelected(position,id,name);
    }
}