NavigationView navigationView=(NavigationView)findViewById(idOfNavigationView);
Menu menu=navigationView.getMenu();
//take a Switch for example
SwitchCompat switch=(SwitchCompat)MenuItemCompat.getActionView(menu.findItem(R.id.menuItemId)).findViewById(R.id.actionLayoutViewId);

//work with the view