private static Foo unmarshalDocument(InputStream xslStream, InputStream xmlStream) throws Exception {
    StreamSource stylesource = new StreamSource(xslStream); 
    StreamSource inputStream = new StreamSource(xmlStream);
    Transformer transformer = TransformerFactory.newInstance().newTransformer(stylesource);
    JAXBResult result = new JAXBResult(context);
    transformer.transform(inputStream, result);
    return (Foo) result.getResult();
}