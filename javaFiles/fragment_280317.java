protected static String createUrl(List<NameValuePair> pairs) throws URIException{

  HttpMethod method = new GetMethod("http://example.org");
  method.setQueryString(pairs.toArray(new NameValuePair[]{}));

  return method.getURI().getEscapedURI();

}