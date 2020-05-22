MultipartEntity entity = new MultipartEntity();
entity.addPart("foo", new InputStreamBody(new ByteArrayInputStream(fooGzippedBytes), "foo.txt"));

HttpPost post = new HttpPost("http://example.com/some");
post.setEntity(entity);

HttpClient client = new DefaultHttpClient();
HttpResponse response = client.execute(post);
// ...