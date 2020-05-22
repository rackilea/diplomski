Bundle params = new Bundle();

params.putString("message", message);
params.put("name", "Cricket Fantasy");
params.put("caption", "New team");
params.put("description","Description about Application");
params.put("url", URLEncoder.encode("http://a.espncdn.com/photo/2010/0523/pg2_a_cricket_576.jpg"));

String response = mFacebook.request("me/feed", params, "POST");