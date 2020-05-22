CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost("http://localhost:8080/kaaAdmin/rest/api/sendNotification");

    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
    builder.addBinaryBody("notification", new File("files/notification.json"),
      ContentType.APPLICATION_JSON, "notification.json");
    builder.addBinaryBody("file", new File("files/file.json"),
          ContentType.APPLICATION_OCTET_STREAM, "file.json");

    HttpEntity multipart = builder.build();
    httpPost.addHeader("Authorization", "Basic AAAAAAAAAAA");
    httpPost.setEntity(multipart);

    CloseableHttpResponse response = client.execute(httpPost);
    System.out.println(response.getStatusLine().getStatusCode());
    client.close();