@Override
public boolean onPrepareOptionsMenu(Menu menu) {
    search = menu.findItem(R.id.action_search);
    super.onPrepareOptionsMenu(menu);
    return true;
}