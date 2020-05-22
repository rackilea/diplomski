tumblrs = new ArrayList<Tumblr> ();
for (int i = 0; i < posts.length(); i++) {
    JSONArray photos = posts.getJSONObject(i).getJSONArray("photos");
    for (int j = 0; j < photos.length(); j++) {
         JSONObject photo = photos.getJSONObject(j);
         String url =
             photo.getJSONArray("alt_sizes").getJSONObject(0).getString("url");
         Tumblr tumblr = new Tumblr(url);
         tumblrs.add(tumblr);
         }
}