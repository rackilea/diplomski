JSONObject json = new JSONObject(readInput()); //readInput() returns the JSON document as String
JSONArray jsonarr = json.getJSONArray("features");
json = jsonarr.getJSONObject(0);
json = json.getJSONObject("geometry");
jsonarr = json.getJSONArray("coordinates");

for(int i=0;i<jsonarr.length();i++){
    JSONObject location = jsonarr.getJSONObject(i);
    String latitude = location.getString("latitude");
    String longitude = location.getString("longitude");
}