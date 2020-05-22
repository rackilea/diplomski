@Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.navigation_map:
                    MapFragment mapFragment = new MapFragment();
                    mapFragment.show(getSupportFragmentManager(),"MapFragment");
                    break;
                case R.id.navigation_search:
                    SearchFragment searchFragment = new SearchFragment();
                    searchFragment.show(getSupportFragmentManager(),"SearchFragment");
                    break;
            }


            return true;
        }
    };