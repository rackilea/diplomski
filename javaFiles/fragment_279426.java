JSONObject featureCollection = new JSONObject();
featureCollection.put("type", "FeatureCollection");
JSONObject properties = new JSONObject();
properties.put("name", "ESPG:4326");
JSONObject crs = new JSONObject();
crs.put("type", "name");
crs.put("properties", properties);
featureCollection.put("crs", crs);

JSONArray features = new JSONArray();
JSONObject feature = new JSONObject();
feature.put("type", "Feature");
JSONObject geometry = new JSONObject();

JSONAray JSONArrayCoord = new JSONArray();

JSONArrayCoord.add(0, 55);
JSONArrayCoord.add(1, 55);
geometry.put("type", "Point");
geometry.put("coordinates", JSONArrayCoord);
feature.put("geometry", geometry);

features.add(feature);
featureCollection.put("features", features);