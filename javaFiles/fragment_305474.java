@Override
    public void characters(char ch[], int start, int length)
        throws SAXException {
        if (insideDefault) {
            currentKey.defaultValue = new String(ch, start, length);
        } else if (insideData) {
            currentData.valueBuilder.append(ch, start, length);
        }
    }