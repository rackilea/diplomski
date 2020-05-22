DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();   

        Document doc = docBuilder.parse(new File("doc1.xml"));

        Element content = (Element)doc.getElementsByTagNameNS("http://comResponse.engine/response", "content").item(0);
        if (content != null)
        {
            System.out.println(content.getTextContent());
            LSSerializer ser = ((DOMImplementationLS)doc.getImplementation()).createLSSerializer();
            if (content.getFirstChild() != null)
            {
              System.out.println(ser.writeToString(content.getFirstChild()));
            }

        }