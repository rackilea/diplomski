public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch(item.getItemId()){
             case R.id.my_account:
               //Do code here
              break;
             case R.id.nav_news:
               //Do code here
             break;
             case R.id.nav_live:
              //Do code here
             break;
             case R.id.nav_media:
              //Do code here
             break;
             case R.id.nav_calendar:
              //Do code here
             break;
             case R.id.nav_results:
              //Do code here
             break;
             case R.id.nav_about:
              //Do code here
             break;
             case R.id.nav_shop:
              //Do code here
             break;
             case R.id.nav_social_media:
              //Do code here
             break;
             case R.id.nav_fanzone:
              //Do code here
             break;

}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }