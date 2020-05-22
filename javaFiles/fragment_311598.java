HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost(connUrl);
try {
    List<BasicNameValuePair> nameValuePairs = new ArrayList<BasicNameValuePair>();
    nameValuePairs.add(new BasicNameValuePair("xml", xml));
    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    HttpResponse response = httpclient.execute(httppost);
    ........
} catch(Exception e) {
    .....
} finally {
      .............
}