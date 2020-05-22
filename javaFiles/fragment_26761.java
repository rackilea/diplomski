@Override
public boolean onOptionsItemSelected(MenuItem item){
    switch(item.getItemId()) {

    case R.id.menu_calendar:
        makeToast("Loading...");
        openCalendar();
        break;
    case R.id.menu_search:
        makeToast("Loading...");
        openSearch();
        break;      
    case R.id.menu_settings:
        openSettings();
        break;
    case R.id.menu_help:
        openHelp();
        break;
    case R.id.menu_about:
        mBackupManager.dataChanged();
        openAbout();
        break;
    }
    return true;
}