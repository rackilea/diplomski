@Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException 
    {
                    final String content = characters.toString().trim();
                    // .... deal with content
                    // reset characters
        characters.setLength(0);
    }

 private final StringBuilder characters = new StringBuilder(64);