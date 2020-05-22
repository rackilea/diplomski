public void startElement(String uri, String localName, String qName,
          Attributes atts) throws SAXException 
{
    //your other node code        

    if(localname.equals("tag")) {
        String k = atts.getValue("k");
        if(iAmInterestedInThisK(k)) {
            String v = atts.getValue("v");
            doSomethingWithThisV(v);
        }
    }
}