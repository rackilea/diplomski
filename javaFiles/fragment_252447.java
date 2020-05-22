JSONObject obj=new JSONObject(jsonresult);
// get result array
JSONArray resultsarray= obj.getJSONArray("results"); 
for (int i=0;i<resultsarray.length(),i++){
        // get Objects using index
        JSONObject jsonobject= results.getJSONObject(i);
        // get geometry object
        JSONObject geometry= jsonobject.getJSONObject("geometry");
        // get location object from geometry
        JSONObject location= geometry.getJSONObject("location");

        // get location values from location object
        double lat = location.optDouble("lat",0.0);
        double long = location.optDouble("lng",0.0);
 }