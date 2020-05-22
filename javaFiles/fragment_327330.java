setCheckable(false) for first item

navigation.getMenu().getItem(0).setCheckable(false);

item.setCheckable(true) inside onNavigationItemSelected()

public boolean onNavigationItemSelected(MenuItem item) {

switch (item.getItemId()) {
    case R.id.navigation_home:
        item.setCheckable(true);
        mTextMessage.setText(R.string.title_home);
        return true;
}
return false;
}