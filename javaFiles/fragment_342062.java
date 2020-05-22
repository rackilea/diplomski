Fragment getFragment = getSupportFragmentManager().getFragments().get(position);
if (getFragment instanceof MoviesFragment) {
    MoviesFragment thisFragment = (MoviesFragment) getFragment;
    if ((position == 0 || position == 2) && positionOffset == 0.0 && positionOffsetPixels == 0)
        thisFragment.onRefresh();
}