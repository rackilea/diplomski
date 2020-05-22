File file = new File(filePath);     
InputStream is = new FileInputStream(file);

HttpClient httpClient = new DefaultHttpClient();
HttpPost postRequest = new HttpPost("http://mysomewebserver.com/services/doSomething.do");


byte[] data = IOUtils.toByteArray(is);

InputStreamBody isb = new InputStreamBody(new
ByteArrayInputStream(data), "filename");
StringBody sb1 = new StringBody("some text goes here");
StringBody sb2 = new StringBody("some text goes here too");
MultipartEntity multipartContent = new MultipartEntity();
multipartContent.addPart("uploadedFile", isb);
multipartContent.addPart("one", sb1);
multipartContent.addPart("two", sb2);

postRequest.setEntity(multipartContent);
HttpResponse response =httpClient.execute(postRequest);
response.getEntity().getContent().close();