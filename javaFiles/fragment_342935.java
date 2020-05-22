boolean handled = true;
switch (item.getItemId()) {
    case R.id.search:
        if (currentFragment == null || !(currentFragment instanceof ClipsFragment)) {
            currentFragment = new ClipsFragment();
        }
        break;
    case R.id.download_managers:
        if (currentFragment == null || !(currentFragment instanceof DownloadFragment)) {
            currentFragment = new DownloadFragment();
        }
        break;
    default:
        handled = false;
}

if (currentFragment != null) {
    fragmentTransaction.replace(R.id.container,
            currentFragment).commit();
}
if (handled) {
    currentDrawerItem = item.getItemId();
}

return handled;