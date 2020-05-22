DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc;
        try {
            builder = factory.newDocumentBuilder();
            doc =  builder.parse(new InputSource( new StringReader("your xml string response")));
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }