public class XMLReceiver {

 public static Document receive(InputStream channel) throws ParserConfigurationException, TransformerConfigurationException, IOException, SAXException {

     DocumentBuilderFactory docBuilderFact = DocumentBuilderFactory.newInstance();
     DocumentBuilder docBuilder = docBuilderFact.newDocumentBuilder();
     Document request = null;


     XMLInputStream xmlin = new XMLInputStream(channel);

     xmlin.recive();

     request = docBuilder.parse(xmlin);

     return request;
 }
}