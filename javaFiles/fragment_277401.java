try
    {
        JSONObject obj = new JSONObject(jsonData);
        JSONArray ja = obj.getJsonArray("data");
        JSONObject jo;
        shops.clear();
        for(int i=0;i<ja.length();i++)
        //................