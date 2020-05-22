JSONArray jarray = new JSONArray("Myjsonstring");
   for(int i=0 ;i<jarray.length();i++)
   {
   JSONObject jb = (JSONObject)jarray.get(i); 
   String id = jb.getString("id");
   String type = jb.getString("type");
   // same for others title, activeform..
   }