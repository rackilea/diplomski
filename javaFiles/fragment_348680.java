public Document getDocument() throws IOException, ParserConfigurationException, SAXException {

  final HttpResponse response = getResponse(); // returns a HttpResonse
  final HttpEntity   entity   = response.getEntity();
  final Charset      charset  = ContentType.getOrDefault(entity).getCharset();  

  // Not 100% sure if I have to close the InputStreamReader. But I guess so.
  try (InputStreamReader isr = new InputStreamReader(entity.getContent(), charset == null ? Charset.forName("UTF-8") : charset)) {
    return documentBuilderFactory.newDocumentBuilder().parse(new InputSource(isr));
  }
}