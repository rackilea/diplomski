mMap = ((SupportMapFragment) getSupportFragmentManager()
            .findFragmentById(R.id.map)).getMap();

    Log.v("ddd", mAddress);

    Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            //To initialice list of address
    List<Address> addresses = null;
    try {
                    //To put the address in list
        addresses = geocoder.getFromLocationName(mAddress, 1);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
            //Get Latitude and longitude
    Address address = addresses.get(0);
    mLongitude = address.getLongitude();
    mlatitude = address.getLatitude();