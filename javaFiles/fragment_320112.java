@Override
public boolean onOptionsItemSelected(
        com.actionbarsherlock.view.MenuItem item) {
    switch (item.getItemId()) {

    case VIEW_PLACES_MENU_ITEM:
        Toast.makeText(getActivity(), EXTRA_EVENT_CATEGORY, Toast.LENGTH_SHORT).show();//This toast is displayed two times.
        // TODO clear markers if any
        clearmarkers();
        // TODO put place markers
        PreferenceManager.getDefaultSharedPreferences(getActivity()).edit()
                .putInt(PREF_MAP_VIEW, VIEW_LOC).commit();
        putLocationMarkers();
        break;
    case VIEW_EVENTS_MENU_ITEM:
        // TODO clear markers if any
        clearmarkers();
        // TODO put event markers
        PreferenceManager.getDefaultSharedPreferences(getActivity()).edit()
                .putInt(PREF_MAP_VIEW, VIEW_EVENT).commit();
        putEventMarkers();
        break;

      default:
            return super.onOptionsItemSelected(item);
    }
    return true;
}