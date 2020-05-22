try{
    JSONObject obj= new JSONObject(result);
    JSONArray jArray = obj.getJSONArray("address");

    //DO ANYTHING WITH jARRAY NOW
}
catch(JSONException e){
    Log.e("log_tag", "Error parsing data "+e.toString());
}