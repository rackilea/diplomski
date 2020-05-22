JSONArray jsonArray = new JSONArray(response);

    for (int i = 0; i < jsonArray.length(); i++) {
         JSONObject row = jsonArray.getJSONObject(i);
         points.add(new LatLng(row.getDouble("positionX"),row.getDouble("positionY")));
        }