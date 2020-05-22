try {
    StreamSource source = new StreamSource(new StringReader("<xml>blabla</xml>"));
    StringWriter writer = new StringWriter();
    StreamResult result = new StreamResult(writer);
    TransformerFactory tFactory = TransformerFactory.newInstance();
    Transformer transformer = tFactory.newTransformer();
    transformer.transform(source,result);
    String strResult = writer.toString();
} catch (Exception e) {
    e.printStackTrace();
}