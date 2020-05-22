try {
            jsonObj = new JSONObject(YourString);
        } catch (JSONException e) {
            Log.v("Error in Parser", " " + e);
        }
    try{

     String name=jsonObj.getString("name"); 
            Data = jsonObj.getJSONArray("data");
                for (int i = 0; i < Data.length(); i++) {       
                        JSONObject jsonObj2 = Data.getJSONObject(j);   
                        String vName = jsonObj2.getString("vendor_name");
                        String vId=jsonObj2.getString("vendor_id");     
                }
}catch(Exception e)
{
}