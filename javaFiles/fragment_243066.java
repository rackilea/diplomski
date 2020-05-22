protected Void doInBackground(...) {
     String result = getResult();
     try {
            JSONArray jsonArray = new JSONArray(result);
            String finalReturn[] = result.split("\\r?\\n");
            if(jsonArray.get(0).toString().equals("4")) {

                for (int i = 1; i < finalReturn.length; i++) {
                    jsonArray = new JSONArray(finalReturn[i]);
                    publishProgress(jsonArray);
                }
            }
     } catch (JSONException e) {
          //handle error
        }
 }

 @Override
 protected void onProgressUpdate(JSONArray... progress) {
     JSONArray array = progress[0];
     IconGenerator iconGenerator = new IconGenerator(getApplicationContext());
     iconGenerator.setStyle(IconGenerator.STYLE_RED);
     iconGenerator.setRotation(90);
     iconGenerator.setContentRotation(-90);
     Bitmap iconBitmap = iconGenerator.makeIcon(jsonArray.get(5).toString());

     Marker marker = mMap.addMarker(new MarkerOptions()
                      .position(new LatLng(jsonArray.getDouble(6), jsonArray.getDouble(7)))
                      .icon(BitmapDescriptorFactory.fromBitmap(iconBitmap)));
     marker.setTitle(jsonArray.getString(1));
     marker.setSnippet(jsonArray.getString(2) + " " + jsonArray.getString(8));
 }