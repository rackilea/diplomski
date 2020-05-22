CloseableHttpClient httpClient = HttpClients.createDefault();
HttpPost uploadFile = new HttpPost("http://localhost:8090/1");

MultipartEntityBuilder builder = MultipartEntityBuilder.create();
String jsonStr = "{\"input1\":\"data1\",\"input2\":\"data2\",\"input3\":\"data3\"}";
builder.addTextBody("json", jsonStr, ContentType.APPLICATION_JSON);
builder.addBinaryBody("file", new File("/path/to/file"),
        ContentType.TEXT_PLAIN, "myFile.dat");

HttpEntity multipart = builder.build();
uploadFile.setEntity(multipart);
HttpResponse response = httpClient.execute(uploadFile);