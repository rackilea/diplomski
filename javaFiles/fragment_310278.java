private static Document getDocumentFromString(final String xmlContent)
  throws Exception
{
    DocumentBuilderFactory documentBuilderFactory =
                                DocumentBuilderFactory.newInstance();
    documentBuilderFactory.setNamespaceAware(true);
    try
    {
        return documentBuilderFactory
                    .newDocumentBuilder()
                    .parse(new InputSource(new StringReader(xmlContent)));
    }
    catch (Exception e)
    {
        throw new RuntimeException(e);
    }
}