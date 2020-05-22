isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

    this.canGetLocation = isNetworkEnabled || isGPSEnabled;

    if(!isNetworkEnabled && !isGPSEnabled){

    }else{
        ...