public static String postJSON(String uri, byte[] req) {
    String queryResponse = null;
    try {
        List<Header> httpHeaders = new ArrayList<Header>();
        httpHeaders.add(HttpClientUtil.ACCEPT_TEXT_HTML);
        HttpResponse response = HttpClientUtil.post(uri, req, ContentType.DEFAULT_BINARY, httpHeaders);
        HttpEntity entity = response.getEntity();

        queryResponse = EntityUtils.toString(entity);

    } catch (ClientProtocolException e) {
        logger.log(java.util.logging.Level.SEVERE, e.getMessage(), e);
    } catch (IOException e) {
        logger.log(java.util.logging.Level.SEVERE, e.getMessage(), e);
    }

    return queryResponse;
  }