@Override
        public boolean onNavigationItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.search_near) {
              addNewFragmentWithBackStack(new FragmentOne());
           }else if(.....){
              addNewFragmentWithBackStack(new FragmentTwo());
           }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;

    }