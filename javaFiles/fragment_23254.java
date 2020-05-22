JSONObject dataObj = new JSONObject(jsonString);
JSONArray results = dataObj.getJSONArray("results");
JSONObject geometry = results.getJSONObject(0).getJSONObject("geometry");
JSONObject location = geometry.getJSONObject("location");
lat = String.valueOf(location.getDouble("lat"));
lng = String.valueOf(location.getDouble("lng"));