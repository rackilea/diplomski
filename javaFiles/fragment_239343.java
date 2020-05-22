try {
    JSONArray jsonArray = new JSONArray(d);
    if(jsonArray != null) {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.optJSONObject(i);

            if(jsonObject == null) {
                continue;
            }

            String name = jsonObject.optString("name");
            String isMe = jsonObject.optString("isMe");
            String time = jsonObject.optString("time");

        }
    }
} catch (JSONException e) {
    e.printStackTrace();
}