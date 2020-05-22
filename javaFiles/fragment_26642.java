locationManagerNetwork = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    Location location2 = locationManagerNetwork
                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

     if (location2 != null) {       
                String message = String
                        .format("Yout location : \n Longitude: %1$s \n Latitude: %2$s",
                                location2.getLongitude(), location2.getLatitude());
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG)
                        .show();


    //use here file writer if you want to write the coordinates in a text file
            }