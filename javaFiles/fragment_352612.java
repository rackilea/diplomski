String stringObj = "[YOUR JSON]";

    // first Convert string into JsonObject
    try {
        JSONObject jsonObject = new JSONObject(stringObj);

        // Inside the above object you have "mylist" key and the respective JsonObject so
        JSONObject myListObject = jsonObject.optJSONObject("mylist");

        // Insdide mylist you have myinfo Json and anim JsonArray
        if(myListObject == null) {
            return;
        }

        JSONObject myinfoObject = myListObject.optJSONObject("myinfo");
        JSONArray animeJsonArray = myListObject.optJSONArray("anime");

        // check null for myinfoObject and animeJsonArray and do the operation

    } catch (JSONException e) {
        e.printStackTrace();
    }