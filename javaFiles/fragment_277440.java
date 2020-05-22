NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {                            
                        switch (menuItem.getItemId()) {
                            case R.id.action_settings:
                                menuItem.setChecked(true);
                                drawerLayout.closeDrawers();
                                doFragmentTransaction();
                        }
                        return true;
                    }
                });
    }