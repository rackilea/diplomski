private Runnable mTask1 = new Runnable() {
    public void run() {
        if(Looper.myLooper() == null) { // check already Looper is associated or not.
           Looper.prepare(); // No Looper is defined So define a new one
        }
        Log.w("GPS Tracker", "Tracker going to run "+new Date());
        LocationManager mlocManager =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener mlocListener = new MyLocationListener();
        mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);//, Looper.getMainLooper()); 
        mTimer1.postDelayed(this, interval1 * 1000L);
        Looper.loop(); 
    }
};