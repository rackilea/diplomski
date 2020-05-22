// parse file and convert it to a DOM
    Document doc = DocumentBuilderFactory
            .newInstance()
            .newDocumentBuilder()
            .parse(new InputSource("test.xml"));

    // use xpath to find node to add to
    XPath xPath = XPathFactory.newInstance().newXPath();
    NodeList nodes = (NodeList) xPath.evaluate("/schema/complexType[@name=\"Containter1\"]",
            doc.getDocumentElement(), XPathConstants.NODESET);

    // create element to add
    org.w3c.dom.Element newElement = doc.createElement("xs:element");
    newElement.setAttribute("type", "element3");
    // set other attributes as appropriate

    nodes.item(0).appendChild(newElement);


    // output
    TransformerFactory
        .newInstance()
        .newTransformer()
        .transform(new DOMSource(doc.getDocumentElement()), new StreamResult(System.out));