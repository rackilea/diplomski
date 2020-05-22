Geocoder geocoder;
List<Address> addresses;
geocoder = new Geocoder(this, Locale.getDefault());
addresses = geocoder.getFromLocation(latitude, longitude, 1);

String address = addresses.get(0).getAddressLine(0);
String city = addresses.get(0).getAddressLine(1);
String country = addresses.get(0).getAddressLine(2);