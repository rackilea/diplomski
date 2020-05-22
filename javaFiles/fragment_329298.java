DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

    Document doc = documentBuilder.newDocument();
    Element element= doc.createElement("element");
    doc.appendChild(element);

    Document newDoc = documentBuilder.parse(new InputSource(new StringReader("<Hello id=\"id\"/>")));

    Element newElement = newDoc.getDocumentElement();
    Node node = doc.importNode(newElement, true);

    element.appendChild(node);