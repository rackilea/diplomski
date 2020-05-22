private List<Item> readRss(XmlPullParser parser) throws XmlPullParserException, IOException {
    List<Item> items = new ArrayList<>();
    parser.require(XmlPullParser.START_TAG, ns, "rss");
    while (parser.next() != XmlPullParser.END_TAG) {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            continue;
        }
        String name = parser.getName();
        if (name.equals("channel")) {
            items.addAll(readChannel(parser));
        } else {
            skip(parser);
        }
    }
    return items;
}