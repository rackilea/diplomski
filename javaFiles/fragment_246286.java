Resources resources = getResources();
    if (resources.getString(R.string.app_name).equalsIgnoreCase("KPM")) {
        MenuItem beaconIconMenuItem = toolbar.getMenu().findItem(R.id.booklist_mylibrary_menu_beacon);
        beaconIconMenuItem.setVisible(false);
        //if kpm app , hide filter icon on toolbar
    } else if (resources.getString(R.string.app_name).equalsIgnoreCase("KPM")) {
        MenuItem filterMenuItem = toolbar.getMenu().findItem(R.id.common_menu_filter);
        filterMenuItem.setVisible(false);
        //if kpm app , hide new collection selection under settings icon on toolbar
    } else if (resources.getString(R.string.app_name).equalsIgnoreCase("KPM")) {
        MenuItem newcollectionMenuItem = toolbar.getMenu().findItem(R.id.booklist_mylibrary_menu_addtab);
        newcollectionMenuItem.setVisible(false);
    }