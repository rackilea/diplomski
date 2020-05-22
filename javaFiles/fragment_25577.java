// This goes somewhere in the activity's onCreate
ImageButton menu_home_button = (ImageButton) findViewById(R.id.action_bar_menu_home);
registerForContextMenu(menu_home_button); //ONLY USE THIS FOR METHOD1
menu_home_button.setLongClickable(true);
menu_home_button.setClickable(true);

// Custom action bar
actionBar = getActionBar();
actionBar.setCustomView(R.layout.my_custom_actionbar);
actionBar.setDisplayShowTitleEnabled(false);
actionBar.setDisplayShowCustomEnabled(true);
actionBar.setDisplayUseLogoEnabled(false);
actionBar.setDisplayShowHomeEnabled(false);