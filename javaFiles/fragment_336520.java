DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    String xmlString = ...;
    Document xml = builder.parse(new ByteArrayInputStream(xmlString.getBytes()));

    XPath xPath = XPathFactory.newInstance().newXPath();
    String expression = "/GTSResponse/Record/Field";
    NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xml,
            XPathConstants.NODESET);

    System.out.println(nodeList);
    System.out.println(nodeList.getLength());

    for (int i = 0; i < nodeList.getLength(); i++) {
        String value = nodeList.item(i).getFirstChild().getNodeValue();
        String name = nodeList.item(i).getAttributes().getNamedItem("name")
                .toString();
        System.out.println(name + ":" + value);

    }