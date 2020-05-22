TransformerFactory transformerFactory = TransformerFactory.newInstance();
Source xsltSource = new StreamSource(new StringReader(
  "<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version='1.0'\n"
+ "    xmlns:xalan='http://xml.apache.org/xalan'>\n"
+ "  <xsl:strip-space elements='*' />\n"
+ "  <xsl:output method='xml' indent='yes' xalan:indent-amount='4' />\n"
+ "  <xsl:template match='/'><xsl:copy-of select='node()' /></xsl:template>\n"
+ "</xsl:stylesheet>"
));
Transformer transformer = transformerFactory.newTransformer(xsltSource);

DOMSource source = new DOMSource(doc);
StreamResult result = new StreamResult(new File("output.xml"));

transformer.transform(source, result);