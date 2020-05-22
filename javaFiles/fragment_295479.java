if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {


        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);


        return;
    }else{
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, this);
    }
    this.onLocationChanged(null);