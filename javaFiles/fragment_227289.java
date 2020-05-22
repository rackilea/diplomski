DocumentBuilderFactory builderFactory =
        DocumentBuilderFactory.newInstance();
DocumentBuilder builder = null;
try {
    builder = builderFactory.newDocumentBuilder();
} catch (ParserConfigurationException e) {
    e.printStackTrace();  
}