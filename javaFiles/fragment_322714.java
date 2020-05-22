public XMLStreamWriter createXMLStreamWriter(Writer w) 
    throws XMLStreamException
{

    return new CDataXmlStreamWriter(f.createXMLStreamWriter(w));
}