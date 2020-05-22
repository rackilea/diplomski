JSONArray jr = new JSONArray("jsonstring");
for(int i=0;i<jr.length();i++)
{
   JSONObject jb = (JSONObject)jr.getJSONObject(i);
   JSONObject jb1 =(JSONObject) jb.getJSONObject("Hospital");
   String name =  jb1.getString("hospital_name");
   Log.i("name....",name);
}