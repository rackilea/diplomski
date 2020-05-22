JSONObject root = new JSONObject(yourJsonString);
JSONArray jsonArray = root.getJSONArray("data");

 for(int i=0; i<jsonArray.length(); i++){
// now loop the element:
JSONObject obj = jsonArray.getJSONObject(i);

String idval = obj.getString("id"); 
String billid1 = obj.getString("billID1");
String billid2 = obj.getString("billID2"); 
}