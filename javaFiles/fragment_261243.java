public static void main(String[] args) throws DocumentException {
  String xml = "<description><text>blahblah</text><code>code</code><text>blah</text></description>";
  SAXReader reader = new SAXReader();
  Document doc = reader.read(new StringReader(xml));
  Element description = doc.getRootElement();
  String content = getContent(description);
  System.out.println(content);
}

private static String getContent(Element element) {
  StringBuilder builder = new StringBuilder();
  for (Iterator<Element> i = element.elementIterator(); i.hasNext();) {
    Element e = i.next();
    builder.append(e.asXML());
  }
  return builder.toString();
}