URI uri = URI.create("http://whatever.com/thingie");
HttpPost post = new HttpPost(uri);
StringEntity ent = new StringEntity("Here is my data!");
post.setEntity(ent);
HttpClient httpClient = new DefaultHttpClient();
HttpResponse response = httpClient.execute(request);