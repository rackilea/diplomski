public static String parseXMLForTag(String xml, String tag) {
        try {
            // Create XMLPullParserFactory & XMLPullParser
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xml));

            // boolean to indicate desired tag has been found
            boolean foundTag = false;
            // variable to fill contents
            StringBuilder tagContents = new StringBuilder();

            // loop over document
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                case XmlPullParser.START_TAG:
                    if (parser.getName().equals(tag)) {
                        // Found tag, start appending to tagContents
                        foundTag = true;
                    } else if (foundTag) {
                        // New start tag inside desired tag
                        tagContents.append("<" + parser.getName() + ">");
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if (parser.getName().equals(tag)) {
                        // Finished gathering text for tag
                        return tagContents.toString();
                    } else if (foundTag) {
                        // end tag inside desired tag
                        tagContents.append("</" + parser.getName() + ">");
                    }
                    break;
                case XmlPullParser.TEXT:
                    if (foundTag) {
                        // text inside desired tag
                        tagContents.append(parser.getText());
                    }
                    break;
                }
                // Get next event type
                eventType = parser.next();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}