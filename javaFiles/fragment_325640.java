private ArrayList<Markerinfo> model = new ArrayList<Markerinfo>();
private ArrayList<String> addressList= new ArrayList<String>();

public void initRequest() {
    APIinterface api = APIrequest.getCient().create(APIinterface.class);
    Call<Mapmarkers> call = api.getMarkerResponse();
    call.enqueue(new Callback<Mapmarkers>() {
        @Override
        public void onResponse(Call<Mapmarkers> call, Response<Mapmarkers> response) {
            if (response.body() != null) {
                model.addAll(response.body().getMarkers());
                for (int i = 0; i < model.size(); i++) {

                    // Add address to list
                    addressList.add(String.valueOf(model.get(i).getLat()) + ", " + String.valueOf( model.get(i).getLong()));

                    createMarker(model.get(i).getLat(), model.get(i).getLong(), model.get(i).getTitle(), model.get(i).getSnippet());
                    LatLng latLng = new LatLng(model.get(i).getLat(), model.get(i).getLong());
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));
                }
            }
        }

        @Override
        public void onFailure(Call<Mapmarkers> call, Throwable t) {
        }
    });
}