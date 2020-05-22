public static void main(String[] args) throws TransformerException {

    String inputString =
        "<root xmlns:a='http://a' xmlns:b='http://b'>" +
        "  <a:element b:attribute='value'>" +
        "    <subelement/>" +
        "  </a:element>" +
        "</root>";

    String xslt = 
        "<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform' xmlns:a='http://a'>" +
        "    <xsl:template match='/root'>" +
        "        <xsl:copy-of select='a:element'/>" +
        "    </xsl:template>" +
        "</xsl:stylesheet>";

    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer(new StreamSource(new StringReader(xslt)));
    transformer.transform(new StreamSource(new StringReader(inputString)), new StreamResult(System.out));
}