HttpClient httpClient = HttpClients.createDefault();
HttpPost httpPost = new HttpPost(url);
MultipartEntityBuilder builder = MultipartEntityBuilder.create();
builder.addTextBody("param1", param1Value, ContentType.TEXT_PLAIN);
builder.addTextBody("param2", param2Value, ContentType.TEXT_PLAIN);
HttpEntity multipart = builder.build();
httpPost.setEntity(multipart);
HttpResponse response = httpClient.execute(httpMethod);