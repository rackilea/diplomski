final StringBuilder sb = new StringBuilder();

@Override
public void characters(char ch[], int start, int length) throws SAXException {
    sb.append(ch, start, length);
}