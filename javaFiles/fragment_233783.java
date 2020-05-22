// Update the object type name from the object type list.
    public void updateObjType(String newTxt, int x)
            throws ParserConfigurationException, SAXException, IOException,
            XPathExpressionException {

        File file = new File("xmlFiles/CoreDatamodel.xml");
        System.out.println("Incoming String value : " + newTxt);
        System.out.println("Index value : " + x);

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory
                .newInstance();

        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        Document xmlDocument = builder.parse(file);

        XPath xPath = XPathFactory.newInstance().newXPath();

        NodeList nodeList = (NodeList) xPath.compile("//OBJECT_TYPE/text()")
                .evaluate(xmlDocument, XPathConstants.NODESET);
        // Set new NodeValue
        nodeList.item(x).setNodeValue(newTxt);

        // Save the new updates
        try {
            save(file, xmlDocument);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }