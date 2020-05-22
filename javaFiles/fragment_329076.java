public class Scratch2 {
    public static void main(String[] args) throws Exception {
        // @formatter:off

        String xml = "<soap-env:envelope xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap-env=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + 
                "   <soap-env:body>\n" + 
                "      <ns4:findsiteconfigurationbysmth xmlns:ns3=\"http://www.testsite.com/common\" xmlns:ns2=\"http://www.testsite.com/plant\" xmlns:ns4=\"someapi:com:plant\" xmlns:ns5=\"someapi:com:reasoncode\">\n" + 
                "         <ns4:response>\n" + 
                "            <ns2:ref>SiteWD:QWERTY</ns2:ref>\n" + 
                "            <ns3:site>QWERTY</ns3:site>\n" + 
                "            <ns3:description>test description</ns3:description>\n" + 
                "            <ns3:timezone>Africa/Abidjan</ns3:timezone>\n" + 
                "         </ns4:response>\n" + 
                "      </ns4:findsiteconfigurationbysmth>\n" + 
                "   </soap-env:body>\n" + 
                "</soap-env:envelope>";

        // @formatter:on

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document myXml = builder.parse(new InputSource(new StringReader(xml)));

        // USING THE CORRECT namespaceURI BELOW
        NodeList nodeList = myXml.getElementsByTagNameNS("http://www.testsite.com/common", "site");

        System.out.println(nodeList.item(0)
                                   .getTextContent());

    }
}