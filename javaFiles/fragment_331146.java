public class XmlTransform
{
  public static void main(String[] args) throws ParseException, TransformerException
  {
    String inXMl = "<Customer>\n" +
            "   <ClientId>123</ClientId>\n" +
            "   <ClientName>ABC</ClientName>\n" +
            "</Customer>";

    StringWriter writer = new StringWriter();
    String inputXSLFile = "d:\\rename.xslt";

    TransformerFactory factory = TransformerFactory.newInstance();
    StreamSource xslStream = new StreamSource(new File(inputXSLFile));
    Transformer transformer = factory.newTransformer(xslStream);

    StreamSource in = new StreamSource(new StringReader(inXMl));
    StreamResult out = new StreamResult(writer);
    transformer.transform(in, out);
    System.out.println(writer.toString());
  }
}