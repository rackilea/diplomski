public LatLng getLocationFromAddress(Context context,String strAddress) {

Geocoder coder = new Geocoder(context);
List<Address> address;
LatLng LatLan= null;

try {
    // May throw an IOException
    address = coder.getFromLocationName(strAddress, 5);
    if (address == null) {
        return null;
    }

    Address location = address.get(0);
    LatLan= new LatLng(location.getLatitude(), location.getLongitude() );

} catch (IOException ex) {

    ex.printStackTrace();
}

return LatLan;
}