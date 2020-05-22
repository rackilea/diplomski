JSONObject json = null;
    try {
        json = new JSONObject(result);
        JSONArray jsonArray = json.getJSONArray("FriendsList");

        for (int j = 0; j < jsonArray.length(); j++) {

            JSONObject jsonObjectData1 = jsonArray.getJSONObject(j);

            String username = jsonObjectData1.getString("username");
            String avatar = jsonObjectData1.getString("avatar");
        }

    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }