isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

    if(!isNetworkEnabled && !isGPSEnabled){

    }else{
        this.canGetLocation = true;
        ...