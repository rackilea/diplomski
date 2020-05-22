public <T extends HttpRequestBase> CloseableHttpResponse sendRequestWithHeaders(Class<T> clazz, String url, Map<String, String> headers) throws IOException {
    CloseableHttpResponse response = null;
    try {
        HttpRequestBase request = clazz.getConstructor(String.class).newInstance(url);
        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                request.setHeader(header.getKey(), header.getValue());
            }
        }
        response = client.execute(request);
    } catch (Exception ex) {
        // handle exception
    }
    return response;
}