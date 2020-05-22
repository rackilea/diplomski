JSONObject forecastJson = new JSONObject(jsonString);
JSONArray forecastArray = forecastJson.getJSONArray("list");
double minTemp, maxTemp;
for(int i = 0; i < forecastArray.length(); i++) {
    JSONObject dailyForecast = forecastArray.getJSONObject(i);
    JSONObject tempObject = dailyForecast.getJSONObject("temp");
    minTemp = tempObject.getDouble("min");
    maxTemp = tempObject.getDouble("max");
    //add these minTemp and maxTemp to array or the 
   //way you want to use
}