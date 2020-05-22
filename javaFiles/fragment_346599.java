HttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost("http://localhost/something");


post.setHeader("Referer", "http://localhost/something");
post.setHeader("Authorization", "Basic (with a username and password)");
post.setHeader("Content-type", "application/json");

// if you need any parameters
List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
urlParameters.add(new BasicNameValuePair("paramName", "paramValue"));
post.setEntity(new UrlEncodedFormEntity(urlParameters));

HttpResponse response = client.execute(post);

HttpEntity entity = response.getEntity();
Header encodingHeader = entity.getContentEncoding();

// you need to know the encoding to parse correctly
Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 : 
Charsets.toCharset(encodingHeader.getValue());

// use org.apache.http.util.EntityUtils to read json as string
String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);

JSONObject o = new JSONObject(json);