JSONArray tracking_users = obj.getJSONArray("tracking_users");
for (int i = 0; i < tracking_users.length(); i++) {
    JSONObject user = tracking_users.getJSONObject(i);
    String _id = user.getString("_id");
    and etc..
}