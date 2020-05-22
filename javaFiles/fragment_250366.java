JSONObject json = new JSONObject(responseStr);
    JSONObject json1 = json.getJSONObject("error");
    //                                  ^^^^^ fetch nested JSON
     JSONArray jsonArray = json1.getJSONArray("group_name");
        for(int i = 0; i<jsonArray.length();i++){
           // JSONObject jsonObject = jsonArray.getJSONObject(i); error
           // jsonArray has no JSONOBJECT but it has String
        }