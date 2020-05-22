public static String getJSONString(HttpResponse response) {
    try {
         DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
         Document doc = builder.parse(response.getEntity().getContent());
         NodeList nl = doc.getElementsByTagName("string");
         Node n = nl.item(0);
         String str = n.getFirstChild().getNodeValue();
         return str;
    } catch (ParserConfigurationException e) {
         e.printStackTrace();
    } catch (SAXException e) {
         e.printStackTrace();
    } catch (IllegalStateException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
 return null;
}