try {

             JSONArray jArray = new JSONArray(result);

             feedsList = new ArrayList<>();

             for (int i = 0; i < jArray.length(); i++) {
                 JSONObject user = jArray.optJSONObject(i);
                 FeedItem item = new FeedItem();
                 item.setTitle(user.optString("full_name"));
                 item.setThumbnail(user.optString("profilePicture"));
                 feedsList.add(item);
             }
         } catch (JSONException e) {
             e.printStackTrace();
         }