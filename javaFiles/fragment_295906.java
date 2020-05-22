handler.startElement(nsu, PERSON_TAG, PERSON_TAG, NO_ATTRIBUTES);

handler.startElement(nsu, FIRSTNAME_TAG, FIRSTNAME_TAG, atts);
handler.characters(this.firstName.toCharArray(), 
        0,
        this.firstName.length());
handler.endElement(nsu, FIRSTNAME_TAG, FIRSTNAME_TAG);

... emit more instance variables

... emit child object like: homeAddress.emitXML(handler, ...);

handler.endElement(nsu, PERSON_TAG, PERSON_TAG);