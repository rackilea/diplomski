String url = "http://www......com/....php";
File file = new File("/path/to/file.ext");

MultipartEntity entity = new MultipartEntity();
entity.addPart("user", new StringBody("user"));
entity.addPart("password", new StringBody("12345"));
entity.addPart("email", new StringBody("info@tutorialswindow.com"));
entity.addPart("file", new InputStreamBody(new FileInputStream(file), file.getName()));

HttpPost post = new HttpPost(url);
post.setEntity(entity);

HttpClient client = new DefaultHttpClient();
HttpResponse response = client.execute(post);
String html = EntityUtils.toString(response.getEntity());

Document document = Jsoup.parse(html, url);
// ...