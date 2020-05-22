private double[] getGPS() {
 LocationManager lm = (LocationManager) getSystemService(
 Context.LOCATION_SERVICE);
 List<String> providers = lm.getProviders(true);

 Location location = null;

 for (int i=providers.size()-1; i>=0; i--) {
     location = lm.getLastKnownLocation(providers.get(i));
     if (location != null) 
         break;
 }

 double[] gps = new double[2];
 if (location != null) {
     gps[0] = location.getLatitude();
     gps[1] = location.getLongitude();
 }

 return gps;
}