JSONObject jsonObj = null;
try{
    jsonObj = new JSONObject(responseString);
    System.out.println(jsonObj.getString("status"));
}
catch(JSONException e){
    e.printStackTrace();
}