Menu menu = navigationView.getMenu();
MenuItem menuItem = menu.findItem(R.id.check_box_menu);
View actionView = MenuItemCompat.getActionView(menuItem);
actionView.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {

  }
});