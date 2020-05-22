for (int i = 0; i < newsItems.length(); i++) {
          try {
                  JSONObject temp = newsItems.getJSONObject(i);
                  String title = temp.getString("webTitle");
                  Log.i("Titles", title);
                  newsFeed.add(new newsItem(title, "This is a small desc", "Jan 1 1999", "12:00", "http://google.gr", R.mipmap.ic_launcher));
                  adapter.notifyDataSetChanged();
                  } catch (JSONException e) {
                          e.printStackTrace();
                    }
}