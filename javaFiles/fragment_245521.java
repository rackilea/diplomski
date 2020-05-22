public boolean onPrepareOptionsMenu(Menu menu)
{
    MenuItem myMenuItem = menu.findItem(R.id.myMenuItemId);
    myMenuItem.setIcon(R.drawable.ic_myAction);
    return true;
}