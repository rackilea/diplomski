public Drawer initDrawerMenu() {
  final Drawer drawer = new DrawerBuilder()
        .withActivity(this)
        .withMultiSelect(false)
        .withOnDrawerItemClickListener(new OnDrawerItemClickListener() {
          @Override
          public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
            switch (position) {
              case 0:
                drawer.closeDrawer(); 
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                break;
            }
            return true;
          }
        })
        .build();

  return drawer;
}