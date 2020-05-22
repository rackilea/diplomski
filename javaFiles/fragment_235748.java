JSONArray jsonarray = new JSONArray(response);
for (int i = 0; i < jsonarray.length(); i++) {
    JSONObject jsonobject = jsonarray.getJSONObject(i);
    String username= jsonobject.getString("username");
    String user_fname= jsonobject.getString("user_fname");
    String user_work= jsonobject.getString("user_work");
}