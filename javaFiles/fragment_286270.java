Element element = ...;

XPath xpath = XPathFactory.newInstance().newXPath();
Node node = (Node) xpath.evaluate("/rsp[@stat='ok']/profile/identifier", element, XPathConstants.NODE);

String value = node != null ? node.getTextContent().trim() : "";