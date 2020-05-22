public void onSearch(View view) {
    String location = edit.getText().toString();
    List<Address> addressList = null;
    if(!location.equals("")) {
        Geocoder geocoder = new Geocoder(this);
        try {
            addressList = geocoder.getFromLocationName(location, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if((addressList == null) || (addressList != null && addressList.size == 0)){
            //Show a dialog here;
            return;
        }
        Address address = addressList.get(0);
        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
        mMap.addMarker(new MarkerOptions().position(latLng).title("Posisi"));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        if(address!=null){
            Toast.makeText(getApplicationContext(),"Location Found", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Location Not Found", Toast.LENGTH_LONG).show();    
        }
   }else if(location.equals("")){
        Toast.makeText(getApplicationContext(), "Nothing Found",Toast.LENGTH_LONG).show();
   }else {
        Toast.makeText(getApplicationContext(), "location null",Toast.LENGTH_LONG).show();
   }    
}