@Test
public void testSO_31815379() throws XMLStreamException, UnsupportedEncodingException {
    final String xml = 
        "<root>\n" +
        "    <element>\n" +
        "        <attribute>level0</attribute>\n" +
        "        <element>\n" +
        "            <attribute>level1</attribute>\n" +
        "            <element>\n" +
        "                <attribute>level2</attribute>\n" +
        "            </element>\n" +
        "        </element>\n" +
        "    </element>\n" +
        "</root>";

    final XMLStreamReader reader = XMLInputFactory.newInstance()
        .createXMLStreamReader(new ByteArrayInputStream(xml.getBytes("UTF-8")));
    LOG.info("Using XMLStreamReader implementation: %s", reader.getClass().getName());

    reader.require(XMLStreamConstants.START_DOCUMENT, null, null);
    int event;
    while ((event = reader.next()) != XMLStreamConstants.END_DOCUMENT) {
        LOG.info(StaxUtils.eventDescription(reader));
    }
    reader.require(XMLStreamConstants.END_DOCUMENT, null, null);
    reader.close();
}