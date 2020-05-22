String xsdFile = "";
SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
try
{
    xsdFile = this.getServlet().getServletContext().getResource("/WEB-INF/resources/schema.xsd").toString();
}
catch (Exception e)
{
    return e.getMessage();
}
Schema schema = schemaFactory.newSchema(new File(xsdFile));