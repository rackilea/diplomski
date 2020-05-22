HttpClient httpclient = new DefaultHttpClient();
JSONParser parser = new JSONParser();

List<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("query", "Blue Bottle"));
params.add(new BasicNameValuePair("key", API_KEY));

String serviceURL = "https://www.googleapis.com/freebase/v1/search";
String url = serviceURL + "?" + URLEncodedUtils.format(params, "UTF-8");      
HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
JSONObject response = (JSONObject)parser.parse(EntityUtils.toString(httpResponse.getEntity()));
JSONArray results = (JSONArray)response.get("result");

for (Object result : results) {
  System.out.println(JsonPath.read(result,"$.name").toString());
}