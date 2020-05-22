public class TestJdom
{
  public static void main(String[] args) throws JDOMException, IOException {
    String xmlString = "<test><tag xml:lang=\"123\"></tag></test>";
    SAXBuilder builder = new SAXBuilder();

    StringReader stringReader = new StringReader(new String(xmlString
        .getBytes()));

    Document doc = builder.build(stringReader);
    List<?> attrs = doc.getRootElement().getChild("tag").getAttributes();
    System.out.println(attrs);
  }
}