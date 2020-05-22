XPathFactory factory = XPathFactory.newInstance();
    XPath xpath = factory.newXPath();
    xPathExpression = xpath.compile("//family[text()='Rest1']/e");

    NodeList list = (NodeList) xPathExpression
        .evaluate(xml, XPathConstants.NODESET);