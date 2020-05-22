try {
   List<LatLng> LatlongList = new ArrayList<LatLng>();
        JSONObject jsonObject = new JSONObject(buffer.toString());
        JSONArray placemarks = jsonObject.getJSONArray("placemarks");

        for (int i = 0; i < placemarks.length(); i++) {
            JSONObject jsonPart = placemarks.getJSONObject(i);
            JSONModels jsonModels = new JSONModels();
            jsonModels.setName(jsonPart.getString("name"));
            jsonModels.setAddress(jsonPart.getString("address"));
            jsonModels.setExterior(jsonPart.getString("exterior"));
            jsonModels.setInterior(jsonPart.getString("interior"));
            jsonModels.setFuel(jsonPart.getInt("fuel"));

            for (int j = 0; j <= 10; j++) {
                JSONObject marker = placemarks.getJSONObject(j);
                JSONArray coordinates = marker.optJSONArray("coordinates");
                double lat = coordinates.optDouble(0);
                double lng = coordinates.optDouble(1);
    //add lat long object in list of LatlongList. 
        LatlongList.add(new LatLng(lat,lng));
            }
     } 
`       //LatlongList is the list where the all lat and longs a together.

    LatlongList.size();
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return LatlongList;