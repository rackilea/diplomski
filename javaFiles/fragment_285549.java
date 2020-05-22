@Override
public void onBackPressed() {
  // for every back press, if there is a fragment to remove, then remove it first
  if (getFragmentManager().getBackStackEntryCount() > 0) {
    getFragmentManager().popBackStack();
    return;
  }
  super.onBackPressed();

}