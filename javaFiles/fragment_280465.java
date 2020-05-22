DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(file);
    doc.getDocumentElement().normalize();
    System.out.println("Root element " + doc.getDocumentElement().getNodeName());

    NodeList nodeList=doc.getElementsByTagName("*");
    for (int i=0; i<nodeList.getLength(); i++) 
    {
        // Get element
        Element element = (Element)nodeList.item(i);
        System.out.println(element.getNodeName());
    }