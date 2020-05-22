HttpTransport httpTransport = new NetHttpTransport();
HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
JSONParser parser = new JSONParser();
String query = "[{\"limit\": 5,\"name\":null,\"type\":\"/medicine/disease\"}]";
GenericUrl url = new GenericUrl("https://www.googleapis.com/freebase/v1/mqlread");
url.put("key", "YOUR-API-KEY-GOES-HERE");
url.put("query", query);
HttpRequest request = requestFactory.buildGetRequest(url);
HttpResponse httpResponse = request.execute();
JSONObject response = (JSONObject)parser.parse(httpResponse.parseAsString());
JSONArray results = (JSONArray)response.get("result");
for (Object result : results) {
  System.out.println(result.get("name").toString());
}