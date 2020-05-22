@SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        FragmentManager fm = getSupportFragmentManager();
        switch (id) {
            case R.id.nav_home:
                Intent homeIntent = new Intent(this, MainActivity.class);
                startActivity(homeIntent);
                break;
            case R.id.nav_contacts:
                fm.beginTransaction().replace(R.id.fl_content, new Contactos(), "Tag").commit();
                break;
            case R.id.nav_about:
                fm.beginTransaction().replace(R.id.fl_content, new Sobre(), "Tag").commit();
                break;
            case R.id.nav_settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class); //Works
                startActivity(settingsIntent);
                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
        }