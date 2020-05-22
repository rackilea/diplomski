private void getCurrentDetails(String data,LatLng myLatlng) throws JSONException {

    JSONObject main = new JSONObject(data);
    double la = main.getDouble("latitude");
    double lon = main.getDouble("longitude");
    JSONObject currently = main.getJSONObject("currently");
    String summary = currently.getString("summary");
    double temperature = currently.getDouble("temperature");
    String icon = currently.getString("icon");

    // Move this upto here
    weatherInfo.add(icon);

    loopi++;
    Log.i("LETSCHECK",""+loopi);
    if (loopi < arrayList.size()) {
        getItAgain();
    } else {
        for (String l:weatherInfo) {
            Log.i("LETSCHECK",l); 
            //expected 4 items to show but its showing only 2 items
        }
    }
}