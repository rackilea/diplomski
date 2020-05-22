@Override
    public void characters(char ch[], int start, int length)
        throws SAXException
    {
        if (insideDefault) {
            currentKey.defaultValue = new String(ch, start, length);
        } else if (insideData) {
            currentData.value = new String(ch, start, length);
        }
    }