import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SO {

   @SuppressWarnings("nls")
   public static void main( String[] args ) throws Exception {
      List< String > names = new ArrayList<>();
      URL oracle =
         new URL( "http://weather.yahooapis.com/forecastrss?w=2502265" );
      InputStream is = oracle.openStream();
      org.w3c.dom.Document doc = null;
      DocumentBuilderFactory domFactory;
      DocumentBuilder builder;
      try {
         domFactory = DocumentBuilderFactory.newInstance();
         domFactory.setNamespaceAware(true);
         builder = domFactory.newDocumentBuilder();
         doc = builder.parse(is);
      } catch (Exception ex) {
         System.err.println("unable to load XML: " + ex);
      }
      XPathFactory factory = XPathFactory.newInstance();
      XPath xpath = factory.newXPath();
      XPathExpression expr = xpath.compile( "//*:*/@*" );
      Object result = expr.evaluate( doc, XPathConstants.NODESET );
      NodeList nl = (NodeList) result;
      for(int j=0 ; j < nl.getLength() ; j++){
         names.add( nl.item(j).getNodeName());
         Node node = nl.item(j);
         String path = "." + node.getNodeName() + " = " + node.getNodeValue();
         node = ((Attr)node).getOwnerElement();
         while( node  != null) {
            path = node.getNodeName() + '/' + path;
            node = node.getParentNode();
         }
         System.out.println( path );
      }
   }
}