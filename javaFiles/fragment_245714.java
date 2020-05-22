@Override
public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

    switch (item.getItemId()) {
    case R.id.menu_item1:
        // change the icon first
        item.setIcon(R.drawable.myAbnormalImage);

        return true;
    default:
        return false;
    }
}