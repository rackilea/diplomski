try {

        // Create the Pull Parser
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();

        // Set the Parser's input to be the XML document in the HTTP Response
        xpp.setInput(new InputStreamReader(response.getEntity()
                .getContent()));

        // Get the first Parser event and start iterating over the XML document 
        int eventType = xpp.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {

            if (eventType == XmlPullParser.START_TAG) {
                startTag(xpp.getName());
            } else if (eventType == XmlPullParser.END_TAG) {
                endTag(xpp.getName());
            } else if (eventType == XmlPullParser.TEXT) {
                text(xpp.getText());
            }
            eventType = xpp.next();
        }
        return mResults;
    } catch (XmlPullParserException e) {
        e.printStackTrace();
    }