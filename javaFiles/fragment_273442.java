@Override
public void onNavigationDrawerItemSelected(int position) {
// update the main content by replacing fragments

FragmentManager fragmentManager = getFragmentManager();
fragmentManager.beginTransaction()
        .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
        .commit();