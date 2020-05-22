// i use ActionBarSherlock library:
    // get an instance of your actionbar and set your navigation mode to tabbar
    mContext.getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    //create a tab and add it to your actionbar
    tabHome = mContext.getSupportActionBar().newTab();
    tabHome.setText(tabItemHome);
    tabHome.setTag(tabItemHome);
    tabHome.setTabListener(this); // TabListener
    mContext.getSupportActionBar().addTab(tabHome);