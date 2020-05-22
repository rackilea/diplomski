CloseableHttpClient client = HttpClients.custom()
        .build();
try (CloseableHttpResponse response = client.execute(new HttpGet("/"))) {
    HttpEntity entity = response.getEntity();
    long expectedLen = entity.getContentLength();
    if (expectedLen != -1 && expectedLen > MAX_LIMIT) {
        throw new IOException("Size matters!!!!");
    }
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    InputStream inputStream = entity.getContent();
    byte[] tmp = new byte[1024];
    int chunk, total = 0;
    while ((chunk = inputStream.read(tmp)) != -1) {
        buffer.write(tmp, 0, chunk);
        total += chunk;
        if (total > MAX_LIMIT) {
            throw new IOException("Size matters!!!!");
        }
    }
    byte[] stuff = buffer.toByteArray();
}