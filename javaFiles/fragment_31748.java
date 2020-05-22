CloseableHttpClient client = HttpClients.custom()
    .disableContentCompression()
    .build();

HttpGet request = new HttpGet(urlSring);
request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");

CloseableHttpResponse response = client.execute(request, context);
HttpEntity entity = response.getEntity();
Header contentEncodingHeader = entity.getContentEncoding();

if (contentEncodingHeader != null) {
    HeaderElement[] encodings =contentEncodingHeader.getElements();
    for (int i = 0; i < encodings.length; i++) {
        if (encodings[i].getName().equalsIgnoreCase("gzip")) {
            entity = new GzipDecompressingEntity(entity);
            break;
        }
    }
}

String output = EntityUtils.toString(entity, Charset.forName("UTF-8").name());