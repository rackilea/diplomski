DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(xmlPath);

        Node node = xml.getElementsByTagName("comprobanteRetencion").item(0);
        Node signature = node.getLastChild();
        node.removeChild(signature);