HttpClient client = new DefaultHttpClient();
HttpPost postMethod = new HttpPost("http://localhost/Upload/index.php");

File file = new File(filePath);

MultipartEntity entity = new MultipartEntity();
FileBody contentFile = new FileBody(file);
entity.addPart("userfile",contentFile);

StringBody contentString = new StringBody("This is contentString");
entity.addPart("contentString",contentString);

postMethod.setEntity(entity);
HttpResponse response = client.execute(postMethod);
HttpEntity httpEntity = response.getEntity();
String state = EntityUtils.toString(httpEntity);