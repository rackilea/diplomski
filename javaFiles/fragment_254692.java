if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
    locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
        Toast.makeText(this, "GPS/Network is Enabled in your device", 
            Toast.LENGTH_SHORT).show();
    }else{
        displayAlert();
    }