public class XPathExample {

    static final String XML =
        "<A>" +
        "  <B><C>test 1</C></B>" +
        "  <B><C>test 2</C></B>" +
        "  <B><C>test 3</C></B>" +
        "</A>";

    public static void main(final String[] args) throws Exception {
        final XPathFactory xpathFactory = XPathFactory.newInstance();
        final XPath xpath = xpathFactory.newXPath();
        final InputSource xml = new InputSource(new StringReader(XML));
        final NodeList list = (NodeList) xpath.evaluate("A/B/C", xml, XPathConstants.NODESET);
        for (int i = 0; i < list.getLength(); i++) {
            final Node node = list.item(i);
            System.out.println(node.getTextContent());
        }
    }

}