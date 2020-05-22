try {
  HttpClient httpclient = new DefaultHttpClient();
  HttpPost httpPost = new HttpPost(authUrl);
  String json = "";
  JSONObject jsonObject = new JSONObject();
  jsonObject.accumulate("phone", "phone");
  json = jsonObject.toString();
  StringEntity se = new StringEntity(json);
  httpPost.setEntity(se);

  httpPost.addHeader("Accept", "application/json");
  httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");

  HttpResponse httpResponse = httpclient.execute(httpPost);

  // 9. receive response as inputStream
  inputStream = httpResponse.getEntity().getContent();
  String response = getResponseBody(inputStream);

  System.out.println(response);

} catch (ClientProtocolException e) {
  System.out.println("ClientProtocolException : " + e.getLocalizedMessage());
} catch (IOException e) {
  System.out.println("IOException:" + e.getLocalizedMessage());
} catch (Exception e) {
  System.out.println("Exception:" + e.getLocalizedMessage());
}