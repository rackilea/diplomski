String data[] = { "String1", "String2" };
JSONArray arr = new JSONArray(Arrays.asList(data));

DefaultHttpClient httpclient = new DefaultHttpClient();

// Put correct URL of your web service.
HttpPost post = new HttpPost("http://example.com");

post.setEntity(new StringEntity(arr.toString()));

HttpResponse response = httpclient.execute(post);