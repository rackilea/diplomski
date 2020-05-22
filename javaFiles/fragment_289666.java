public static void main(String[] args) throws IOException, TransformerException, SAXException {
    XMLReader reader = XMLReaderFactory.createXMLReader();
    TransformerFactory tf = TransformerFactory.newInstance();
    // Load the transformer definition from the file strip.xsl:
    Transformer t = tf.newTransformer(new SAXSource(reader, new InputSource(new FileInputStream("strip.xsl"))));
    // Transform the file test.xml to stdout:
    t.transform(new SAXSource(reader, new InputSource(new FileInputStream("test.xml"))), new StreamResult(System.out));
}