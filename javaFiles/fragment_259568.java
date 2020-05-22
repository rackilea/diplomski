// get Json forecast object
JSONObject forecasts_obj = json.getJSONObject("forecast");
// get Json simpleforecast object
JSONObject simpleforecast_obj = forecasts_obj.getJSONObject("simpleforecast");

// get Json forecastday Array
JSONArray forecastday_arr = simpleforecast_obj.getJSONArray("forecastday");

for (int i=0;i<forecastday_arr.length();i++) {                        
    HashMap<String, String> map = new HashMap<String, String>();    
    JSONObject e = forecastday_arr.getJSONObject(i);

    String icon = e.getString("icon");
    map.put("id", String.valueOf(i));
    map.put("icon", icon);
    mylist.add(map);            
}