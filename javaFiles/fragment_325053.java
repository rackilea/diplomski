String string = "text#text##text#0;text" + '\u0000' + "text<text&text#";
    Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    Element element = document.createElement("element");
    element.appendChild(document.createTextNode(escapeInvalidXmlCharacters(string)));
    document.appendChild(element);
    TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(new File("test.xml")));
    // creates <?xml version="1.0" encoding="UTF-8" standalone="no"?><element>text##text####text##0;text#0;text&lt;text&amp;text##</element>
    document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("test.xml"));
    System.out.println(unescapeInvalidXmlCharacters(document.getDocumentElement().getTextContent()).equals(string));
    // prints true