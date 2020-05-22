try {
    StringReader reader = new StringReader("<xml>blabla</xml>");
    StringWriter writer = new StringWriter();
    TransformerFactory tFactory = TransformerFactory.newInstance();
    Transformer transformer = tFactory.newTransformer(
            new javax.xml.transform.stream.StreamSource("styler.xsl"));

    transformer.transform(
            new javax.xml.transform.stream.StreamSource(reader), 
            new javax.xml.transform.stream.StreamResult(writer));

    String result = writer.toString();
} catch (Exception e) {
    e.printStackTrace();
}