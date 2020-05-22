// buffer to hold description
private StringBuffer descriptionBuffer;
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if ("item".equals(qName)) {
        currentItem = new Item();
    } else if ("title".equals(qName)) {
        parsingTitle = true;
    } else if ("description".equals(qName)) {
        parsingDescription = true;
        // initialize buffer
        descriptionBuffer = new StringBuffer();
    }
}

@Override
public void endElement(String uri, String localName, String qName) throws SAXException {

    System.out.println("Testing endelement");

    if ("item".equals(qName)) {
        Items.add(currentItem);
        currentItem = null;
    } else if ("title".equals(qName)) {
        parsingTitle = false;
    } else if ("description".equals(qName)) {
        // Put contents of buffer into description
        currentItem.setDescription(descriptionBuffer.toString());
        descriptionBuffer = null;
        parsingDescription = false;
    }
}

@Override
public void characters(char[] ch, int start, int length) throws SAXException {

    System.out.println("writing");

    if (parsingTitle) {
        if (currentItem != null)
            currentItem.setTitle(new String(ch, start, length));
    } else if (parsingDescription) {
        // add to buffer
        descriptionBuffer.append(ch, start, length); 
    }
}