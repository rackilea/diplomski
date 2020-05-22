protected FragmentTabHost mTabHost;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
}

@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    super.onCreateOptionsMenu(menu, menuInflater);
    Fragment currentFragment = getChildFragmentManager().findFragmentByTag(mTabHost.getCurrentTabTag());
    if (currentFragment != null && currentFragment instanceof BaseTabsPagerChildFragment)
        ((BaseTabsPagerChildFragment) currentFragment).inflateOptionsMenu(menu, menuInflater);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    if (super.onOptionsItemSelected(item)) {
        return true;
    } else {
        Fragment currentFragment = getChildFragmentManager().findFragmentByTag(mTabHost.getCurrentTabTag());
        if (currentFragment != null && currentFragment instanceof BaseTabsPagerChildFragment) {
            return ((BaseTabsPagerChildFragment) currentFragment).onOptionsItemSelected(item);
        }
    }
    return false;
}