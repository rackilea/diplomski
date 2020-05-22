HttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost("http://localhost:8080/YourApp/YourAction");

try {
    List<NameValuePair> params = new ArrayList<NameValuePair>(1);
    params.add(new BasicNameValuePair("name", name));
    post.setEntity(new UrlEncodedFormEntity(params));

    HttpResponse response = client.execute(post);

    HttpEntity entity = response.getEntity();
    // Server response as stream
    InputStream inputStream = entity.getContent();
} catch (ClientProtocolException cpe) {
    cpe.printStackTrace();
}