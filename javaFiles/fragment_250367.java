JSONObject json = new JSONObject(responseStr);
    JSONObject json1 = json.getJSONObject("error");
    //                                  ^^^^^ fetch nested JSON
     JSONArray jsonArray = json1.getJSONArray("group_name");
        for(int i = 0; i<jsonArray.length();i++){
           String str = jsonArray.optString(i);
        }