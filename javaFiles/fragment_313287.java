List<LatLng> path = new ArrayList();
  for(int j = 0; j< numSteps; ++j){
    final JSONObject step = steps.getJSONObject(j);

    final JSONObject polyline = step.getJSONObject("polyline");
    final String polylinePoint = polyline.getString("points");


    List<LatLng> coordinates = decodePath(polylinePoint);
    for( int k = 0; k < coordinates.size(); ++k){
        path.add(coordinates.get(k));
    }
 }