// Returns the type of current event: START_TAG, END_TAG, etc..
            News currentNewsItem = null;
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG) {
                    if (xpp.getName().equalsIgnoreCase("item")) {
                        insideItem = true;

                    // Get LINK
                    } else if (xpp.getName().equalsIgnoreCase("link")) {
                        if (insideItem) {
                            // If no item is currently in progress, start one
                            currentNewsItem = startNewItemIfRequired(currentNewsItem, newsArray);

                            currentNewsItem.link = xpp.nextText();
                             Log.i("log-", "LINK: " + currentNewsItem.link);
                        }

                    // Get TITLE
                    } else if (xpp.getName().equalsIgnoreCase("title")) {
                        if (insideItem) {
                            // Start a new news item, even if one is already in progress 
                            currentNewsItem = startNewItemIfRequired(null, newsArray);

                            currentNewsItem.title = xpp.nextText();
                             Log.i("log-", "TITLE: " + currentNewsItem.title);
                        }

                    // Get MEDIA URL
                    } else if (xpp.getName().equalsIgnoreCase("media:content")) {
                        if (insideItem)
                            // If no item is currently in progress, start one
                            currentNewsItem = startNewItemIfRequired(currentNewsItem, newsArray);

                            currentNewsItem.imageURL = xpp.getAttributeValue(null, "url");
                             Log.i("log-", "MEDIA URL: " + currentNewsItem.imageURL);
                    }

                } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
                    insideItem = false;
                }

                eventType = xpp.next(); // move to next element

            } // end WHILE loop

        } catch(Exception e) { e.printStackTrace(); }