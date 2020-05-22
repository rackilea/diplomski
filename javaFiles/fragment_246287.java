private void setupToolbar() {
    toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
    String appName = getResources().getString(R.string.app_name).toLowerCase();
    toolbar.setTitle(appName.equals("pnm e-reader") ? "My Books" : getString(R.string.booklist_drawer_mylibrary));
    toolbar.inflateMenu(R.menu.booklist_mylibrary_menu);
    switch (appName) {
        case "kpm":
            Menu menu = toolbar.getMenu();

            MenuItem beaconIconMenuItem = menu.findItem(R.id.booklist_mylibrary_menu_beacon);
            MenuItem filterMenuItem = menu.findItem(R.id.common_menu_filter);
            MenuItem newcollectionMenuItem = menu.findItem(R.id.booklist_mylibrary_menu_addtab);

            beaconIconMenuItem.setVisible(false);
            newcollectionMenuItem.setVisible(false);
            filterMenuItem.setVisible(false);
            break;
    }
}