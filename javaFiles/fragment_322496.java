protected void onRestoreInstanceState(Bundle savedInstanceState){
    super.onRestoreInstanceState(savedInstanceState);

/////Set restorePoints to true.
    restorePoints = true;           
    Points = database.getSavedPoints();
}

@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
    mMap.setMyLocationEnabled(true);
    mMap.getUiSettings().setZoomControlsEnabled(true);
    mMap.getUiSettings().setAllGesturesEnabled(true);

///// Here I draw the line during onMapReady();
    if(restorePoints){
        drawLine();
        restorePoints = false;
    }
}