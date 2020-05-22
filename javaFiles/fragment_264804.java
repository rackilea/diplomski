XMLInputFactory xif = XMLInputFactory.newFactory();
StreamSource xml = new StreamSource("src/forum14234091/input.xml");
XMLStreamReader xsr = xif.createXMLStreamReader(xml);

xsr = xif.createFilteredReader(xsr, new StreamFilter() {
    @Override
    public boolean accept(XMLStreamReader xsr) {
        if(xsr.isStartElement() || xsr.isEndElement()) {
            return !"urn:schemas-microsoft-com:xml-diffgram-v1".equals(xsr.getNamespaceURI());
        }
        return true;
    }
});