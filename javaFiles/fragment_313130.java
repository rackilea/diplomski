for ( i = 0; i < MyArrListx.size(); i++) {
  n = Double.parseDouble(MyArrListx.get(i));
  e = Double.parseDouble(MyArrListy.get(i));
  String phone = (MyArrListphonenumber.get(i));
  map.addMarker(new MarkerOptions().position(new LatLng(n, e)) 
                .title("Click to Call Transporter !!").snippet( phone )
                .position(new LatLng(n, e)))
                .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
}



map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {

            //Just get the phone number stored in the snippet, and dial
            String phone = marker.getSnippet();
            dialContactPhone(phone);
        }
    });