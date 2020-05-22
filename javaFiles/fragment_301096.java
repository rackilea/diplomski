DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();    
InputSource inputSource = new InputSource(new StringReader(xml));
Document document = builder.parse(inputSource);
XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
XPathExpression expr = xpath.compile("/fileVersionListWrapper/VersionList[@versionNumber='1.81']");
NodeList nl = (NodeList) expr.evaluate(document, XPathConstants.NODESET);