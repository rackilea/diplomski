// ********************************************************************************
    public void checkLocation(Activity activity) {
        locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
        Criteria c = new Criteria();
        provider = locationManager.getBestProvider(c, false);

        location = getLocation(activity);
        List<String> providers = locationManager.getProviders(true);

    for (String provider : providers) {
        Location l = locationManager.getLastKnownLocation(provider);
        Log.d("Location provider", "Location provider : " + l + "locationManager" + locationManager);
        if (l == null) {

            continue;
        } else {
            location = l;
            break;

        }

    }
        locationManager.requestLocationUpdates(provider, 400, 1, this);
        locationManager.removeUpdates(this);

        if (location != null) {
            // get latitude and longitude of the location
            onLocationChanged(location);
            // display on text view

        } else {
            // Toaster.showToast(this,
            // getResources().getString(R.string.NoConnection));
            Log.d("cahngeLag", "Lat: " + lat + "lng" + lng + "location" + location);
        }
    }

    // ===============================GetLatLang============================
    public Location getLocation(Activity activity) {
        try {
            locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);

            // getting GPS status
            isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

            // getting network status
            isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {
                // no network provider is enabled
            } else {
                if (isNetworkEnabled) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 400, 0, this);
                    Log.d("Network", "Network Enabled");
                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            lat = location.getLatitude();
                            lng = location.getLongitude();
                        }
                    }
                }
                // if GPS Enabled get lat/long using GPS Services
                if (isGPSEnabled) {
                    if (location == null) {
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 400, 0, this);
                        Log.d("GPS", "GPS Enabled");
                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                lat = location.getLatitude();
                                lng = location.getLongitude();
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return location;
    }

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lng = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }