@Override
public void onConfigurationChanged(Configuration newConfig) {
  super.onConfigurationChanged(newConfig);
  // Pass any configuration change to the drawer toggles
  drawerToggle.onConfigurationChanged(newConfig);
}