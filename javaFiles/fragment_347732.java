protected void onPostExecute(String s) {
    super.onPostExecute(s);
    try {
        loadIntoTextView(s);

        // MOVED FROM onMapReady
        LatLng myAddressCoordinates = getLocationFromAddress(TVStringa.getText().toString());
          //LatLng myAddressCoordinates = getLocationFromAddress("Piazza Ferretto Mestre");
          mapView.addMarker(new MarkerOptions().position(myAddressCoordinates).title(Indirizzo));
          mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(myAddressCoordinates, 16));

    } catch (JSONException e) {
        e.printStackTrace();
    }
}