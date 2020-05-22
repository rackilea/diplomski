public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_camera) {
        //I want to call the page " calculations" here.
        //with this code you can call a new activity
        Intent intent = new Intent(this, YourActivity.class);
        startActivity(intent);
    } else if (id == R.id.nav_gallery) {
        //create another Intent here and navigate to the correct activity
}