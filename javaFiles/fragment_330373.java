@Override
public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

    int id = menuItem.getItemId();
    if (id == R.id.callUs) {
        Intent intent = new Intent(Intent.ACTION_CALL);

        intent.setData(Uri.parse("tel:" + "XXXxxxXXX"));

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
        }
        else
        {
            startActivity(intent);
        }
   }
   else
   {
       // Make your navController object final above
       // or call Navigation.findNavController() again here
       NavigationUI.onNavDestinationSelected(menuItem, navController);
   }
   drawer.closeDrawer(GravityCompat.START);
   return true;