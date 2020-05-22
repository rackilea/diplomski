HttpRequestFactory reqFact = new HttpRequestFactory() {
  public HttpRequest newHttpRequest(final RequestLine requestline) throws MethodNotSupportedException {
    return new BasicHttpEntityEnclosingRequest(requestline);
  }

  public HttpRequest newHttpRequest(final String method, final String uri) throws MethodNotSupportedException {
    return new BasicHttpEntityEnclosingRequest(method, uri);
  }
};
HttpMessageParserFactory<HttpRequest> parserFact = new DefaultHttpRequestParserFactory(null, reqFact);
HttpConnectionFactory<DefaultBHttpServerConnection> connFact = new DefaultBHttpServerConnectionFactory(null, parserFact, null)