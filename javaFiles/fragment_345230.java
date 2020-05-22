private long lat, lng;
//.. onCreate
   lat = getIntent().getLongExtra("lat");
   lng = getIntent().getLongExtra("lon");

//...
GeoPoint office = new GeoPoint(lat, lng);
OverlayItem oi = new OverlayItem(office, "", "");
itemizedOverlay.addOverlay(oi);
//.. and so on.