LocationManager mlocManager =

(LocationManager)getSystemService(Context.LOCATION_SERVICE);

LocationListener mlocListener = new MyLocationListener();


mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);