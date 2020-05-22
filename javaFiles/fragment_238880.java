public void onMenuItemClicked(View view) {
    switch (view.getId()) {
    case R.id.menu_add_inquiry:
        Intent intent = new Intent(DropDownMenu.this,NewLead.class);
        startActivity(intent);
        break;
    case R.id.menu_other:
        // handle other menu item
        break;
    // ... and so on ...
    default:;
    }
}