@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.my_menu_id, menu);
}

@Override
public boolean onContextItemSelected(MenuItem item) {
    AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
    switch (item.getItemId()) {
        case R.id.menu_home:
            open_home();
            return true;
        case R.id.menu_how_to:
            open_how_to();
            return true;
        case R.id.menu_rate:
            open_rate();
            return true;
        case R.id.menu_about:
            open_about();
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}