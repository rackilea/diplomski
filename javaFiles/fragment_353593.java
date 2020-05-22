private void readDocument(XmlPullParser parser) throws XmlPullParserException, IOException {
    while (parser.next() != XmlPullParser.END_TAG) {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            continue;
        }
        String name = parser.getName();
        if (name.equals("name")) {
            readName(parser);
        } else if (name.equals("currency")) 
               readCurrency(parser);
        else {
            skip(parser);
        }
    }  
}