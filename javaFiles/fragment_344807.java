public void search(View v){

EditText textbox = (EditText) findViewById(R.id.editText1);
String location = textboxt.getText().toString();
if (location.length() == 0) {
    Toast.makeText(this, "Please Enter a location", Toast.LENGTH_SHORT).show();
}else{

try{

Geocoder gc = new Geocoder(this);

List<Address> list = gc.getFromLocationName(location, 1);


if(list.size()!=0){

Address add = list.get(0);
String locality = add.getLocality();
    double lat = add.getLatitude();
double lng = add.getLongitude();
LatLng ll = new LatLng(lat, lng);
Gmap.moveCamera(CameraUpdateFactory.newLatLng(ll));
        // zoom in Google map
        Gmap.animateCamera(CameraUpdateFactory.zoomTo(20));
}else{
 Toast.makeText(this, "Location not found", Toast.LENGTH_SHORT).show();
 } 

}catch(Exception e){
e.printstacktrace();

      }
    }
  }