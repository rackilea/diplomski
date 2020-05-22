int eventType = parser.getEventType();
    int Categories = 0;
    while (eventType != XmlPullParser.END_DOCUMENT) {
        if (eventType == XmlPullParser.START_TAG) {
            Categories++;
        } if (eventType == XmlPullParser.START_TAG && Categories == 1) {
            Categories++;
        } if (eventType == XmlPullParser.START_TAG && Categories == 2) {
            categorys.add(parser.getText());
        }
        parser.next();
    }