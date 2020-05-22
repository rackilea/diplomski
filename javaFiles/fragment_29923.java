String str = "[{\"name\":\"Muhaimin\",\"address\":\"Sylhet\",\"bgroup\":\"o+\"}]";
    try {
        JSONArray json = new JSONArray(str);
        Log.d(TAG, "Json value :" + json);
        Log.d(TAG, "Json value :" +    json.getJSONObject(0).getString("bgroup"));
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }