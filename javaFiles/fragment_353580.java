Location lastLocation = LocationServices.FusedLocationApi
                .getLastLocation(mGoogleApiClient);

    if (lastLocation != null) {
        double latitude = lastLocation.getLatitude();
        double longitude = lastLocation.getLongitude();

//Once you get the coordinates, you can retrieve the city name using the Geocoder class:

        Geocoder gcd = new Geocoder(getBaseContext(), Locale.getDefault());
        List<Address> addresses;
            addresses = gcd.getFromLocation(latitude, longitude, 1);
            if (addresses != null) {
                if (addresses.size() > 0)
                    String cityName = addresses.get(0).getLocality();

            }

         }