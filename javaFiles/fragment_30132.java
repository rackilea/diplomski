button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Menu menu = navigationView.getMenu();
        SubMenu topChannelMenu = menu.addSubMenu("Category");
        topChannelMenu.add("Menu Name");
        MenuItem mi = menu.getItem(menu.size()-1);
        mi.setTitle(mi.getTitle());
    }
});