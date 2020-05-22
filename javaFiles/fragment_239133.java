try {
        JSONObject obj = new JSONObject(loadJSONFromAsset());
        JSONArray jsonArray = obj.getJSONArray("tray");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject stories = jsonArray.getJSONObject(i);
            String userid = stories.getJSONObject("user").getString("pk");
            String username = stories.getJSONObject("user").getString("username");
            String profile_pic = stories.getJSONObject("user").getString("profile_pic_url");

            JSONArray resultArray = stories.getJSONArray("items");
            for (int i1 = 0; i1 < resultArray.length(); i1++) {
                JSONObject items = resultArray.getJSONObject(i1).getJSONObject("image_versions2");
                JSONArray images = items.getJSONArray("candidates");
                JSONObject urls = images.getJSONObject(0);
                storie_url = urls.getString("url");
                Log.d("Url", "onCreate: " + storie_url);
            }
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }