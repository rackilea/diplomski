JSONArray values = new JSONArray(resultString);
for(int i = 0 ; i < values.length(); i++){
    JSONObject object = (JSONObject) values.get(i); 
    String id = object.getString("id");
    //the same for the rest
}