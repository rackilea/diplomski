String jsonString = a.toString();
    try
    {
        JSONArray json = new JSONArray(jsonString);
        for(int index = 0; index < json.length(); ++index)
        {
            JSONObject obj = json.getJSONObject(index);
            String str_value = obj.getString("Question");
            Log.i("JSON", str_value);
        }
    }
    catch (JSONException e)
    {
        e.printStackTrace();
        // Do something to recover ... or kill the app.
    }