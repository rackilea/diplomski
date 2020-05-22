public void postData() {
// Create a new HttpClient and Post Header
HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost("http://184.82.158.234/~store/rest/system/connect.json");

try {
    // Add your data
    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
    nameValuePairs.add(new BasicNameValuePair("id", "12345"));
    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

    // Execute HTTP Post Request
    HttpResponse response = httpclient.execute(httppost);

} catch (ClientProtocolException e) {
    // TODO Auto-generated catch block
} catch (IOException e) {
    // TODO Auto-generated catch block
}
}