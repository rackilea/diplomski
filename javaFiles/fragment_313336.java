try {
    JSONfunctions j=new JSONfunctions();
    JSONArray jArray = j.getJSONfromURL(url);
    Log.i("log_tag", jArray.toString()); 

     for(int i=0;i<jArray.length();i++){
      JSONObject json_data = jArray.getJSONObject(i);
      String jsonvalues =  json_data.getString("id");
      // .. get all value here
      Log.i("DARE", jsonvalues);  
   }
  }
catch (Exception ex)
   {
    Log.e("log_tag", "Error getJSONfromURL "+ex.toString());           
  }