private void readCurrency(XmlPullParser parser) throws XmlPullParserException, IOException {
    parser.require(XmlPullParser.START_TAG, ns, "currency");
    while (parser.next() != XmlPullParser.END_TAG) {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            continue;
        }
        String name = parser.getName();
        if (name.equals("euro")) {
            euro = readEuro(parser);
        } else if (name.equals("dollar")) {
            dollar = readDollar(parser);
        } else {
            skip(parser);
        }
    }
}

// Read in the content of the Euro element.
private String readEuro(XmlPullParser parser) {
    return readText(parser);
}