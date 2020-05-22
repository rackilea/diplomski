MultipartEntityBuilder builder = MultipartEntityBuilder.create();
builder.addTextBody("message", messageStr, ContentType.TEXT_PLAIN.withCharset(UTF_8));
for (File file: files) {
    builder.addBinaryBody(
            "attachment",
            new FileInputStream(file),
            ContentType.APPLICATION_OCTET_STREAM,
            file.getName()
    );
}
CloseableHttpClient httpClient = HttpClients.createDefault();
HttpPost uploadFile = new HttpPost(url);
uploadFile.setEntity(builder.build());
CloseableHttpResponse response = httpClient.execute(uploadFile);