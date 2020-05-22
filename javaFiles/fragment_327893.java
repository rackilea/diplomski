@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setHasOptionsMenu(true);
};

@Override
public void inflateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    onCreateOptionsMenu(menu, menuInflater);
}

@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    super.onCreateOptionsMenu(menu, menuInflater);
    menuInflater.inflate(R.menu.message_actionbar_menu, menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    boolean handled = super.onOptionsItemSelected(item);
    if (handled) {
        return true;
    }
    int itemId_ = item.getItemId();
    if (itemId_ == R.id.menu_item_compose) {
        launchCompose();
        return true;
    }
    if (itemId_ == R.id.menu_item_delete) {
        doDelete();
        return true;
    }
    return false;
}