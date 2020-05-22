public ResponseEntity<String> execute(String url, HttpMethod httpMethod, Object o)
{
    HttpEntity request = new HttpEntity(o, this.header);
    ResponseEntity<String> resp = null;
    this.header.set("Authorization", token.getTokenType() + " " + token.getValue());
    try {
        resp = this.client.exchange(url, httpMethod, request, String.class);
    } catch (Exception e) {
        String str = getStackTrace(e);
        if (StringUtils.containsIgnoreCase(str, "SocketTimeoutException")) {
            throw new KeycloakHTTPClientSocketException(
                "Got a SocketTimeoutException for URL:" + url + ", HTTPMethod:" + httpMethod);
        } else
            throw new Exception(...);
    }
    return resp;
}