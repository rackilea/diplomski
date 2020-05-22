/**
 * Show selected fragment and hide other.
 *
 * Could not use ft.hide/show for SupportMapFragment because this caused
 * big delays coming back to main screen from other activities when the SupportMapFragment was
 * in its hidden state. It also caused the UI to become unresponsive.
 * 
 * I solved this by hiding/showing the SupportMapFragment by removing/adding the fragment for
 * its container view. Working on 2.3.3 and Honeycomb --> KitKat emulators
 */
private void showFragment(Fragment fragmentIn) {
    if (fragmentIn == null || mFragmentVisible == fragmentIn) {
        return;
    }

    View mapView=mMapFragment.getView();

    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

    if(fragmentIn instanceof map_fragment){
        //show map
        if (mapView.getParent()!=mFragmentContainer) { //mFragmentContainer is FrameLayout
            mFragmentContainer.addView(mapView);
        }
        ft.hide(mPlaceListFragment);
    }else{
        //show list
        mFragmentContainer.removeView(mapView);
        ft.show(mPlaceListFragment);
    }

    ft.commit();

    mFragmentVisible = fragmentIn;
}