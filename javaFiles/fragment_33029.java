@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_enter, menu);
    SubMenu submenu = menu.addSubMenu(0, Menu.NONE, Menu.NONE, "My Account");
    //submenu.add(0, 10, Menu.NONE, "My Profile");
    //submenu.add(0, 15, Menu.NONE, "Change Job");
    SubMenu submenu2 = submenu.addSubMenu(0, Menu.NONE, Menu.NONE, "Change Job");
    submenu2.add(0, 100, Menu.NONE, "Pilot");
    submenu2.add(0, 105, Menu.NONE, "Fligh Attendant");
    submenu2.add(0, 110, Menu.NONE, "Technical");
    //submenu.add(0, 20, Menu.NONE, "Log Out");
    return true;
}