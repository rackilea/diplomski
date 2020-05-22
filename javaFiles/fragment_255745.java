XPath xPath = XPathFactory.newInstance().newXPath();
Node startDateNode = (Node) xPath.compile("/data/startdate").evaluate(doc, XPathConstants.NODE);
startDateNode.setTextContent("29/07/2015");

xPath = XPathFactory.newInstance().newXPath();
Node endDateNode = (Node) xPath.compile("/data/enddate").evaluate(doc, XPathConstants.NODE);
endDateNode.setTextContent("29/07/2015");