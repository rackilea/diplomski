@Override
public void onBackPressed() {

    if (mSelectedItem == R.id.menu_notifications) {

        MenuItem searchItem = mBottomNav.getMenu().getItem(1);
        selectFragment(searchItem);
        mBottomNav.setSelectedItemId(searchItem.getItemId());

    } else if (mSelectedItem == R.id.menu_search) {

        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
        selectFragment(homeItem);
        mBottomNav.setSelectedItemId(homeItem.getItemId());

    } else {
        super.onBackPressed();
    }
}