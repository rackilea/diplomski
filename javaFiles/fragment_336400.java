FragmentManager fragmentManager = getSupportFragmentManager();
// (if you're not using the support library)
// FragmentManager fragmentManager = getFragmentManager();
for (Fragment fragment : fragmentManager.getFragments()) {
    if (fragment != null && fragment.isVisible() && fragment instanceof MyListFragment) {
        ((MyListFragment) fragment).changeLanguage();
    }
}