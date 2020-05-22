private List<Item> readChannel(XmlPullParser parser) throws XmlPullParserException, IOException {
    List<Item> items = new ArrayList<>();
    parser.require(XmlPullParser.START_TAG, ns, "channel");
    while (parser.next() != XmlPullParser.END_TAG) {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            continue;
        }
        String name = parser.getName();
        if (name.equals("item")) {
            items.add(readItem(parser));
        } else {
            skip(parser);
        }
    }
    return items;
}