int mytotal;
if (result instanceof JSONArray) {
    JSONArray jsonArray = (JSONArray) result;       
     JSONObject jo = jsonArray.getJSONObject(0);
      mytotal = jo.getInt("total");
    }