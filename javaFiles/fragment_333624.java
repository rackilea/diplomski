JSONArray jsonArray = new JSONArray(response);
for(int i=0;i<jsonArray.length;i++){
   JSONObject jsonObj = jsonArray.getJSONObject(i);
   String id = jsonObj.getString("id");
   String encodedString = jsonObj.getString("imagen");
   Log.i("DATA","Id: "+id);
}