DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = f.newDocumentBuilder();

    Document d = builder.newDocument();
    Element root = d.createElement("root");
    d.appendChild(root);
    root.setTextContent("this text contains the \u2227 character");

    Transformer t = TransformerFactory.newInstance().newTransformer();
    t.setOutputProperty(OutputKeys.ENCODING, "US-ASCII");
    t.setOutputProperty(OutputKeys.INDENT, "yes");
    t.transform(new DOMSource(d), new StreamResult(System.out));