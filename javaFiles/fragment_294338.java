@Override
public boolean onCreateOptionsMenu(Menu menu){
    super.onCreateOptionsMenu(menu);
    createMenu(menu);
    return true;
}

private void createMenu(Menu menu){
    MenuItem mnu1 = menu.add(0, 0, 0, "Logout");
    {
        mnu1.setAlphabeticShortcut('a');
        mnu1.setIcon(R.drawable.icon);
        mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }
}