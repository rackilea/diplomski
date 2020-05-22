final CloseableHttpClient httpclient = HttpClients.createDefault();         
final HttpGet request = new HttpGet("http://any-url");

try (CloseableHttpResponse response = httpclient.execute(request)) {
    final int status = response.getStatusLine().getStatusCode();

    if (status == 200) {
        final InputStream is = response.getEntity().getContent();
    } else {
        throw new IOException("Got " + status + " from server!");
    }
}
finally {
    request.reset();
}