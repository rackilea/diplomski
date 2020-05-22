public void getAddress(double lat, double lng) {
    Geocoder geocoder = new Geocoder(HomeActivity.mContext, Locale.getDefault());
    try {
        List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
        Address obj = addresses.get(0);
        String add = obj.getAddressLine(0);
        GUIStatics.currentAddress = obj.getSubAdminArea() + ","
                + obj.getAdminArea();
        GUIStatics.latitude = obj.getLatitude();
        GUIStatics.longitude = obj.getLongitude();
        GUIStatics.currentCity= obj.getSubAdminArea();
        GUIStatics.currentState= obj.getAdminArea();
        add = add + "\n" + obj.getCountryName();
        add = add + "\n" + obj.getCountryCode();
        add = add + "\n" + obj.getAdminArea();
        add = add + "\n" + obj.getPostalCode();
        add = add + "\n" + obj.getSubAdminArea();
        add = add + "\n" + obj.getLocality();
        add = add + "\n" + obj.getSubThoroughfare();

        Log.v("IGA", "Address" + add);
        // Toast.makeText(this, "Address=>" + add,
        // Toast.LENGTH_SHORT).show();

        // TennisAppActivity.showDialog(add);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}