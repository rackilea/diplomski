HttpClient httpClient = new DefaultHttpClient();
HttpPost httpPost = new HttpPost("http://example.com/uploadservlet");
MultipartEntity entity = new MultipartEntity();
entity.addPart("fieldname", new InputStreamBody(fileContent, fileContentType, fileName));
httpPost.setEntity(entity);
HttpResponse servletResponse = httpClient.execute(httpPost);