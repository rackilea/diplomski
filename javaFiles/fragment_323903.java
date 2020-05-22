HttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost(targetURL);
List<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("name", "xyz"));
params.add(new BasicNameValuePair("home", "xyz"));
post.setEntity(new UrlEncodedFormEntity(params));
HttpResponse response = client.execute(post);
InputStream input = response.getEntity().getContent();
// ...