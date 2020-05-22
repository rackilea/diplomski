public void onResponse(JSONArray response) {
    try {
        for (int i = 0; i < response.length(); ++i) {
            JSONObject obj = response.getJSONObject(i);
            id[0] = obj.getString("id");
            getid.add(id[0]);
        }
        // MOVE YOUR STUFF TO HERE
    } catch (JSONException e) {
        e.printStackTrace();
    }
}