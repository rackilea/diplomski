public void endElement(String uri, String localName, String qName) throws SAXException {
    if (qName.equalsIgnoreCase("Razon_Social_Propietario")) {
        bRazon_Social_Propietario = false;
    } else if (qName.equalsIgnoreCase("Calle_propietario")) {
        bCalle_propietario = false;
    }
}