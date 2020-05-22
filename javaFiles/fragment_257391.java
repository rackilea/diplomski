JSONObject data = new JSONObject(data);

                 JSONArray userInform = data.getJSONArray("users_information");

                 for(int i = 0; i < userInform.length(); i++) {
JSONObject c = userInform.getJSONObject(i);
 Log.e("id ", c.getString("id"));
}