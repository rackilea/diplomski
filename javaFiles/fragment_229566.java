new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray responsenews) {
                    try {
                          for (int i = 0; i < responsenews.length(); i++) {
                              JSONObject object = responsenews.getJSONObject(i);
                              int id = object.getInt("idnews");
                              String content = object.getString("content");
                              String image = object.getString("image");
                        }
                    }catch (JSONException e) {
                         e.printStackTrace();
                    }
                }
            }