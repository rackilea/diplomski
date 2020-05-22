private static String url = "https://graph.facebook.com/331394590231184/feed";
JSONParser jParser = new JSONParser();
List<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("access_token", "**|*****"));
params.add(new BasicNameValuePair("client_id", "***"));
params.add(new BasicNameValuePair("client_secret", "****"));
JSONObject json = jParser.makeHttpRequest(url, "GET", params);
JSONArray data = json.getJSONArray("data");