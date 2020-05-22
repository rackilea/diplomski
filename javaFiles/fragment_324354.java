@Override
protected void onPostCreate(Bundle savedInstanceState) {
  super.onPostCreate(savedInstanceState);
  // Sync the toggle state after onRestoreInstanceState has occurred.
  drawerToggle.syncState();
}