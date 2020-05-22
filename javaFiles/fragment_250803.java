private boolean isNetworkConnected() {
  ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
  NetworkInfo ni = cm.getActiveNetworkInfo();
  if (ni == null) {
   // There are no active networks.
   return false;
  } else
   return true;
 }