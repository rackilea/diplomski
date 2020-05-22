public void startElement(String uri, String localName,
    String qName, Attributes attributes)
    throws SAXException {

    if("row".equals(localName)) {
        //this code is executed for every xml element "row"
        String id = attributes.getValue("id");
        String PostTypeId = attributes.getValue("PostTypeId");
        String AcceptedAnswerId = attributes.getValue("AcceptedAnswerId");
        //others two
        // you have your att values for an "row" element
    }

 }