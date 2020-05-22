double latiude[] = null;
double longitude[] = null;
 JSONObject  json=JSONFunction.getJSONfromURL(Url);
 try{ 
    JSONArray  JArray = json.getJSONArray("results");  
      latitude = new double[jArray.length/size()];
      longitude = new double[jArray.length/size()];
      Log.v(TAG, "getting results"); 
    for(int i=0;i<JArray.length();i++)
     {
            JSONObject e = JArray.getJSONObject(i); 
            JSONObject location1=e.getJSONObject("geometry").getJSONObject("location");  
            latitude[i]=location1.getDouble("lat"); 
            longitude[i]=location1.getDouble("lng"); 
      }