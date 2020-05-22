CloseableHttpClient httpClient = HttpClientBuilder.create()
        .build();

HttpEntity requestEntity = MultipartEntityBuilder.create()
        .addBinaryBody("file", new File("data_test/json_test.json"))
        .build();
HttpPost post = new HttpPost("http://domain.com/api/upload_json/");
post.setEntity(requestEntity);
try (CloseableHttpResponse response = httpClient.execute(post)) {
    System.out.print(response.getStatusLine());
    EntityUtils.consume(response.getEntity());
}