try
    {
        JSONArray jArray = new JSONArray(jsonString);

        for(int i=0;i<jArray.length();i++)
        {
           JSONObject jsonObj = jArray.getJSONObject(i);

           String NotificationID =jsonObj.getString("NotificationID");
           String TaskID=jsonObj.getString("TaskID");
           String Sender=jsonObj.getString("Sender");
           String NotificatonMessage=jsonObj.getString("NotificatonMessage"); 
           String NotificationCategory=jsonObj.getString("NotificationCategory"); 

        }
    }
    catch(JSONException e)
    {
        Log.e("log_tag", "Error parsing data "+e.toString());
    }