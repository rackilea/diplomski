@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);

    MenuItem item = menu.findItem(R.id.menu_switch);
    switchButton = (SwitchCompat) MenuItemCompat.getActionView(item);

    return super.onCreateOptionsMenu(menu);
}