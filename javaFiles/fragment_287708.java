public String parseXMLResponse(String sXMLData) throws IOException, SAXException, ParserConfigurationException {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(true);
        dbFactory.setValidating(false);
        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sXMLData.getBytes("UTF-8"));

        Document document = docBuilder.parse(inputStream);

        NodeList nodeList = document.getElementsByTagName("Property");
        String userUuId = null; 
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String el = element.getAttribute("name");
            if(el.equalsIgnoreCase("UserId"))
            {
                userUuId = element.getAttribute("value");
                break;
            }
        }

        return userUuId;
    }