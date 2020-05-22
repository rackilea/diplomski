final List<MenuItem> items=new ArrayList<>();
for(int i=0; i<menu.size(); i++){
    items.add(menu.getItem(i));
}
...
navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        ...
        navigationView.getMenu().getItem(previousItem).setChecked(false);
        item.setChecked(true);
        previousItem = items.indexOf(navigationView.getMenu().findItem(item.getItemId()));
...
}