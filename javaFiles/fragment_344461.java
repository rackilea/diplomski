@Override
public boolean onMenuItemSelected(int featureId, MenuItem item) {
    switch (item.getItemId()) {
    case R.id.action_settings:
        startSettings();
        return true;
    }
    return super.onMenuItemSelected(featureId, item);
}