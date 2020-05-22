private StringBuffer curCharValue = new StringBuffer(1024);

@Override
public void startElement (String uri, String localName,
              String qName, Attributes attributes) throws SAXException {
    if(qName.equals("author")){
        curCharValue.clear();
    }
}

@Override
public void characters (char ch[], int start, int length) throws SAXException
{
     //already synchronized
    curCharValue.append(char, start, length);
}

@Override
public void endElement (String uri, String localName, String qName)
throws SAXException
{
    if(qName.equals("author")){
        String author = curCharValue.toString();
    }
}