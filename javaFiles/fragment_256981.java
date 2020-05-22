Transformer tx = TransformerFactory.newInstance().newTransformer();
    tx.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("1.xml"));
    NodeList list = doc.getElementsByTagName("Operation");
    for (int i = 0; i < list.getLength(); i++) {
        DOMSource src = new DOMSource(list.item(i));
        StringWriter sr = new StringWriter();
        Result res = new StreamResult(sr);
        tx.transform(src, res);
        System.out.println(sr);
    }