@Override
public void endElement(String uri, String localName, String qName)
        throws SAXException {

    currentElement = false;

    /** set value */
    if (localName.equalsIgnoreCase("tag"))
            {
        sitesList.setName(currentValue);
                    currentValue = ""; //reset the currentValue
            }

}

@Override
public void characters(char[] ch, int start, int length)
        throws SAXException {

    if (in_Tag) {
        currentValue += new String(ch, start, length); //keep appending string, don't set it right here....maybe there's more to come.
    }

}