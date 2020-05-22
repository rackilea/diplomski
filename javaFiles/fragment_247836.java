startDocument(){
    writer.writeStartDocument("UTF-8", "1.0");
}

public void startElement(String namespaceURI, String localName,
                         String qName, Attributes atts)  {

    writer.writeStartElement(namespaceURI, localName);
    for(int i=0; i<atts.getLength(); i++){
        writer.writeAttribute(atts.getQName(i), atts.getValue(i));
    }
} 

public void endElement(String uri, localName, qName){
    writer.writeEndElement();
}