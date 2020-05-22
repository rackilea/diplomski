public void openMapFragment() {
    Fragment fragment = new gMapFragment();
    replaceFragment(fragment);
}

//moved to Activity from the Fragment
public void replaceFragment(Fragment someFragment) {
    FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction.replace(R.id.fragment_container, someFragment);
    transaction.addToBackStack(null);
    transaction.commit();
}