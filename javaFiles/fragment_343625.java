<!-- language: java -->

while (parser.next() != XmlPullParser.END_TAG) {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            continue;
        }
        String tag = parser.getName();
        if (tag.equals("topartists")) {
            MyLog.d(TAG, "tag == " + tag);
            tag = parser.getName();

        } else if (tag.equals("artist")) {
            MyLog.d(TAG, "tag == " + tag);
            artistsList.add(readArtist(parser));
        } else {
            skip(parser);
        }
    }