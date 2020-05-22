public class HandlerRegistrarActa extends DefaultHandler {
    private RegistrarActaBeanReq acta = null;
    private boolean bRazon_Social_Propietario = false;
    private boolean bCalle_propietario = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("id_Acta")) {
            bid_Acta = true;
            acta = new RegistrarActaBeanReq();
        } else if (qName.equalsIgnoreCase("Razon_Social_Propietario")) {
            bRazon_Social_Propietario = true;
        } else if (qName.equalsIgnoreCase("Calle_propietario")) {
            bCalle_propietario = true;
        } 
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    public void characters(char ch[], int start, int length) throws SAXException {

        if (bRazon_Social_Propietario) {
            acta.setRazon_Social_Propietario(new String(ch, start, length).trim());
            bRazon_Social_Propietario = false;
        } else if (bCalle_propietario) {
            acta.setCalle_Propietario(new String(ch, start, length).trim());
            bCalle_propietario = false;
        } 
    }
}