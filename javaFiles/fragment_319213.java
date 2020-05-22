ActionBar actionBar = getSupportActionBar();
actionBar.setDisplayShowHomeEnabled(false);
actionBar.setDisplayShowCustomEnabled(true);
actionBar.setDisplayShowTitleEnabled(false);
View customView = getLayoutInflater().inflate(R.layout.main_action_bar, null);
actionBar.setCustomView(customView);
Toolbar parent =(Toolbar) customView.getParent();
parent.setContentInsetsAbsolute(0,0);