public void onResponse(JSONArray response) {
    try {
             JSONObject jObj = new JSONObject(finalResult);
             String count= jObj.getString("COUNT(id)");
             tv.setText(count);
    } catch (JSONException e) {
         e.printStackTrace();
    }