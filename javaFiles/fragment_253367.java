String xmlSource = "your xml";
String xpathExpression = "//element[@scoCode='C1']/@foo | //element[@scoCode='C1']/@bar";

XPath xpath = XPathFactory.newInstance().newXPath();
StringReader reportConfigurationXML = new StringReader(xmlSource);
InputSource inputSource = new InputSource(reportConfigurationXML);

String result = (String) xpath.evaluate(xpathExpression, inputSource, XPathConstants.STRING);