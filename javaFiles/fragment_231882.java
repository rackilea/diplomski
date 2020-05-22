@Override
    public void onRequestPermissionsResult(int requestCode,
            String permissions[], int[] grantResults) {
               if (grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        // Write you code here if permission already given.
        mLocationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        mLocationManager.addGpsStatusListener(this);
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 0, this);
    }                           }else{
                            // you must ask location permission again
                            }
    }