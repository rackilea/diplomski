// plot each point as a circle
 for (int i = 0; i < jsonArray.length(); i++) {
     JSONObject startPt = jsonArray.getJSONObject(i).getJSONObject("start");
     JSONObject endPt = jsonArray.getJSONObject(i).getJSONObject("end");
     LatLng start = new LatLng(Double.parseDouble(startPt.getString("lat")), Double.parseDouble(startPt.getString("lng")));
     LatLng end = new LatLng(Double.parseDouble(endPt.getString("lat")), Double.parseDouble(endPt.getString("lng")));
     int c = colors[(i % colors.length)];
     mMap.addCircle(new CircleOptions().center(start).strokeColor(c).fillColor(c).radius(1));
     mMap.addCircle(new CircleOptions().center(end).strokeColor(Color.BLACK).fillColor(c).radius(1).strokeWidth(2));

     Log.d(TAG, "d  = "+SphericalUtil.computeDistanceBetween(start,end));
 }
 mMap.addCircle(new CircleOptions().center(centerOfGridCell).strokeColor(Color.WHITE).radius(1).strokeWidth(4));