public void onResponse(JSONArray response) {
    try {
             JSONObject jObj = new JSONObject(response.get(0));
             String count= jObj.getString("COUNT(id)");
             tv.setText(count);
    } catch (JSONException e) {
         e.printStackTrace();
    }