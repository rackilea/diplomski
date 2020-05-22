HttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost("http://localhost:8090/geoserver/ows?Service=WPS");
HttpEntity entity = new ByteArrayEntity(xmlString.getBytes("UTF-8"));
post.setEntity(entity);
HttpResponse response = client.execute(post);
// parse the json data in the response with a streaming model as it will be big