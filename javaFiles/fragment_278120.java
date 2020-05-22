if (Constants.isOnline(getApplicationContext())) {
                        gps = new GPSTracker(v.getContext(),this);
                        if (gps.canGetLocation()) {

                            latitude = gps.getLatitude();
                            longitude = gps.getLongitude();
                            Log.e("Location ", "latitude : " + latitude + "longitude :" + longitude);

                        } else {
                            gps.showSettingsAlert();
                        }
                }