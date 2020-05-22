public class DummyHandler extends DefaultHandler{
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);
        System.out.println("characters! dear god, I've located a text value");
    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        super.endElement(uri, localName, name);
        System.out.println("an element was ended. may it R.I.P. o7");
    }

    @Override
    public void startElement(String uri, String localName, String name,
            Attributes attributes) throws SAXException {
        super.startElement(uri, localName, name, attributes);
        System.out.println("uh! oh! I've just hit an element openening tag");
    }
}