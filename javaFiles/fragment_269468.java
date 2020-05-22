public void sendMessage(CloseableHttpClient client, String endpointUrl, String jsonString) throws IOException {
    HttpPost post = new HttpPost(endpointUrl);
    post.addHeader("Content-Type", "application/json; charset=utf-8"); // Apache would probably set it for you, but since I'm not 100% sure, I added it here.
    post.setEntity(new StringEntity(jsonString, ContentType.create("application/json", Consts.UTF_8))); // here the actual conversion takes place and only here do you need to worry about encoding
    try (CloseableHttpResponse response = client.execute(post)) {
        // act on response here
    }
}