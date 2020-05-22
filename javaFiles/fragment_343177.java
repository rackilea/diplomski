resultObject = resultObject.getJSONObject("result"); // <---
                    places = new MarkerOptions[1];
                    LatLng placeLL = null;
                    String placeName = "";
                    String vicinity = "";
                    try {
                        JSONObject placeObject = resultObject;
                        JSONObject loc = placeObject.getJSONObject(
                                "geometry").getJSONObject("location");
                        placeLL = new LatLng(Double.valueOf(loc
                                .getString("lat")), Double.valueOf(loc
                                .getString("lng")));
                        vicinity = placeObject.getString("vicinity");
                        placeName = placeObject.getString("name");
                    } catch (JSONException jse) {
                        missingValue = true;
                        jse.printStackTrace();
                    }
                    if (missingValue){
                        result = null;
                    } else {
                        places[0] = new MarkerOptions().position(placeLL)
                                .title(placeName).snippet(vicinity);
                    }