public void convertXmlToJson(InputStream in, OutputStream out) throws XMLStreamException {
    XMLEventReader xmlIn = XMLInputFactory.newFactory().createXMLEventReader(in);
    OutputStreamWriter osw;
    try {
        osw = new OutputStreamWriter(out, "UTF8");
    } catch (UnsupportedEncodingException e) {
        throw new RuntimeException(e.toString(), e); // not possible really
    }
    MappedXMLStreamWriter jsonOut = new MappedXMLStreamWriter(new MappedNamespaceConvention(), osw);
    AbstractXMLEventWriter xmlOut = new AbstractXMLEventWriter(jsonOut);
    while (xmlIn.hasNext()) {
        XMLEvent ev = xmlIn.nextEvent();
        if (ev instanceof Characters && ((Characters)ev).isWhiteSpace()) {
            continue;
        }
        xmlOut.add(ev);
    }
    xmlOut.close();
}