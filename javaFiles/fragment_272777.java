public class MovieReader
{

  public static void main(String[] args)
  {
    String actorsName = "Brus_Wuillis";

    String xml = "<actors>\n" +
             "    <Brus_Wuillis>\n" +
             "        <films>\n" +
             "            <word>A</word>\n" +
             "            <film_name>Armageddon</film_name>\n" +
             "            <year>1998</year>\n" +
             "            <genre>Action</genre>\n" +
             "        </films>\n" +
             "        <films>\n" +
             "            <word>S</word>\n" +
             "            <film_name>Sin City</film_name>\n" +
             "            <year>2005</year>\n" +
             "            <genre>Thriller</genre>\n" +
             "        </films>\n" +
             "        <films>\n" +
             "            <word>A</word>\n" +
             "            <film_name>A Good Day to Die Hard</film_name>\n" +
             "            <year>2013</year>\n" +
             "            <genre>Action</genre>\n" +
             "        </films>\n" +
             "    </Brus_Wuillis>\n" +
             "</actors>";


    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = null;
    try
    {
      builder = factory.newDocumentBuilder();
    }
    catch (ParserConfigurationException e)
    {
      e.printStackTrace();
    }
    try
    {
      InputSource is = new InputSource(new StringReader(xml)) ;
      Document doc = builder.parse(is);
      XPathFactory xPathfactory = XPathFactory.newInstance();
      XPath xpath = xPathfactory.newXPath();
      XPathExpression expr = xpath.compile("/actors/"+ actorsName +"/films[word=\"A\"]");
      NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
      for (int i = 0; i < nl.getLength(); i++)
      {
        Node node =  nl.item(i);
        System.out.println(nl.item(i).getNodeName());
        Element element = (Element) node;
        Node filmNode = element.getElementsByTagName("film_name").item(0);;
        System.out.println(filmNode.getTextContent());
      }
    }
    catch (SAXException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (XPathExpressionException e)
    {
      e.printStackTrace();
    }
  }
}