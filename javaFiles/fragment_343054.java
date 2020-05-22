private void getCurrentDetails(String data,LatLng myLatlng) throws JSONException{
    JSONObject main = new JSONObject(data);
    double la = main.getDouble("latitude");
    double lon = main.getDouble("longitude");
    JSONObject currently = main.getJSONObject("currently");
    String summary = currently.getString("summary");
    double temperature = currently.getDouble("temperature");
    String icon = currently.getString("icon");

    LatLng latLngo = new LatLng(la,lon);
    ter.add(latLngo);
    weatherInfo.add(icon);

    // Now initiate the next call
    i++;
    if(i < arrayLis.size()) getItAgain();

    Log.i("LETSCHECK",""+la+", "+lon +icon);
}

public void getItAgain() {
    // Just start the first task without the loop. 
    double latitude = ((LatLng)arrayLis.get(i)).latitude;
    double longitude = ((LatLng)arrayLis.get(i)).longitude;
    String url = "https://api.darksky.net/forecast/APIKEY/"
            +latitude+","+longitude+"?units=si";
    LatLng mylatlng = new LatLng(latitude,longitude);
    startProcess(url,mylatlng);
}