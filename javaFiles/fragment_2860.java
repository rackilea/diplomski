while (xmlStreamReader.hasNext()) {
    int event = xmlStreamReader.next();

    if (event == XMLStreamConstants.START_ELEMENT) {
        try {
            String text = xmlStreamReader.getElementText();
            System.out.println("Element Local Name:" + xmlStreamReader.getLocalName());
            System.out.println("Text:" + text);
        } catch (XMLStreamException e) {

        }
    }

}