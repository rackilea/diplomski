final String TAG_FEED = "feed";

public int parseXml(Reader reader) {
    XmlPullParserFactory factory = null;
    StringBuilder out = new StringBuilder();
    int entries = 0;

    try {
        factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(reader);

        while (true) {
            int eventType = xpp.next();
            if (eventType == XmlPullParser.END_DOCUMENT) {
                break;
            } else if (eventType == XmlPullParser.START_DOCUMENT) {
                out.append("Start document\n");
            } else if (eventType == XmlPullParser.START_TAG) {
                String tag = xpp.getName();
                // out.append("Start tag " + tag + "\n");
                if (TAG_FEED.equalsIgnoreCase(tag)) {
                    entries = parseFeed(xpp);
                }
            } else if (eventType == XmlPullParser.END_TAG) {
                // out.append("End tag " + xpp.getName() + "\n");
            } else if (eventType == XmlPullParser.TEXT) {
                // out.append("Text " + xpp.getText() + "\n");
            }
        }
        out.append("End document\n");

    } catch (XmlPullParserException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    //        return out.toString();
    return entries;

}

private int parseFeed(XmlPullParser xpp) throws XmlPullParserException, IOException {
    int depth = xpp.getDepth();
    assert (depth == 1);
    int eventType;
    int entries = 0;
    xpp.require(XmlPullParser.START_TAG, null, TAG_FEED);
    while (((eventType = xpp.next()) != XmlPullParser.END_DOCUMENT) && (xpp.getDepth() > depth)) {
        // loop invariant: At this point, the parser is not sitting on
        // end-of-document, and is at a level deeper than where it started.

        if (eventType == XmlPullParser.START_TAG) {
            String tag = xpp.getName();
            // Log.d("parseFeed", "Start tag: " + tag);    // Uncomment to debug
            if (FeedEntry.TAG_ENTRY.equalsIgnoreCase(tag)) {
                FeedEntry feedEntry = new FeedEntry(xpp);
                feedEntry.persist(this);
                entries++;
                // Log.d("FeedEntry", feedEntry.title);    // Uncomment to debug
                // xpp.require(XmlPullParser.END_TAG, null, tag);
            }
        }
    }
    assert (depth == 1);
    return entries;
}

class FeedEntry {
    String id;
    String published;
    String updated;
    // Timestamp lastRead;
    String title;
    String subtitle;
    String authorName;
    int contentType;
    String content;
    String preview;
    String origLink;
    String thumbnailUri;
    // Media media;

    static final String TAG_ENTRY = "entry";
    static final String TAG_ENTRY_ID = "id";
    static final String TAG_TITLE = "title";
    static final String TAG_SUBTITLE = "subtitle";
    static final String TAG_UPDATED = "updated";
    static final String TAG_PUBLISHED = "published";
    static final String TAG_AUTHOR = "author";
    static final String TAG_CONTENT = "content";
    static final String TAG_TYPE = "type";
    static final String TAG_ORIG_LINK = "origLink";
    static final String TAG_THUMBNAIL = "thumbnail";
    static final String ATTRIBUTE_URL = "url";

    /**
    * Create a FeedEntry by pulling its bits out of an XML Pull Parser. Side effect: Advances
    * XmlPullParser.
    * 
    * @param xpp
    */
public FeedEntry(XmlPullParser xpp) {
    int eventType;
    int depth = xpp.getDepth();
    assert (depth == 2);
    try {
        xpp.require(XmlPullParser.START_TAG, null, TAG_ENTRY);
        while (((eventType = xpp.next()) != XmlPullParser.END_DOCUMENT)
        && (xpp.getDepth() > depth)) {

            if (eventType == XmlPullParser.START_TAG) {
                String tag = xpp.getName();
                if (TAG_ENTRY_ID.equalsIgnoreCase(tag)) {
                    id = Util.XmlPullTag(xpp, TAG_ENTRY_ID);
                } else if (TAG_TITLE.equalsIgnoreCase(tag)) {
                    title = Util.XmlPullTag(xpp, TAG_TITLE);
                } else if (TAG_SUBTITLE.equalsIgnoreCase(tag)) {
                    subtitle = Util.XmlPullTag(xpp, TAG_SUBTITLE);
                } else if (TAG_UPDATED.equalsIgnoreCase(tag)) {
                    updated = Util.XmlPullTag(xpp, TAG_UPDATED);
                } else if (TAG_PUBLISHED.equalsIgnoreCase(tag)) {
                    published = Util.XmlPullTag(xpp, TAG_PUBLISHED);
                } else if (TAG_CONTENT.equalsIgnoreCase(tag)) {
                    int attributeCount = xpp.getAttributeCount();
                    for (int i = 0; i < attributeCount; i++) {
                        String attributeName = xpp.getAttributeName(i);
                        if (attributeName.equalsIgnoreCase(TAG_TYPE)) {
                            String attributeValue = xpp.getAttributeValue(i);
                            if (attributeValue
                            .equalsIgnoreCase(FeedReaderContract.FeedEntry.ATTRIBUTE_NAME_HTML)) {
                                contentType = FeedReaderContract.FeedEntry.CONTENT_TYPE_HTML;
                                } else if (attributeValue
                                .equalsIgnoreCase(FeedReaderContract.FeedEntry.ATTRIBUTE_NAME_XHTML)) {
                                    contentType = FeedReaderContract.FeedEntry.CONTENT_TYPE_XHTML;
                                } else {
                                    contentType = FeedReaderContract.FeedEntry.CONTENT_TYPE_TEXT;
                                }
                                break;
                            }
                        }
                        content = Util.XmlPullTag(xpp, TAG_CONTENT);
                        extractPreview();
                    } else if (TAG_AUTHOR.equalsIgnoreCase(tag)) {
                        // Skip author for now -- it is complicated
                        int authorDepth = xpp.getDepth();
                        assert (authorDepth == 3);
                        xpp.require(XmlPullParser.START_TAG, null, TAG_AUTHOR);
                        while (((eventType = xpp.next()) != XmlPullParser.END_DOCUMENT)
                        && (xpp.getDepth() > authorDepth)) {
                        }
                        assert (xpp.getDepth() == 3);
                        xpp.require(XmlPullParser.END_TAG, null, TAG_AUTHOR);

                    } else if (TAG_ORIG_LINK.equalsIgnoreCase(tag)) {
                        origLink = Util.XmlPullTag(xpp, TAG_ORIG_LINK);
                    } else if (TAG_THUMBNAIL.equalsIgnoreCase(tag)) {
                        thumbnailUri = Util.XmlPullAttribute(xpp, tag, null, ATTRIBUTE_URL);
                    } else {
                        @SuppressWarnings("unused")
                            String throwAway = Util.XmlPullTag(xpp, tag);
                    }
                }
            } // while
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert (xpp.getDepth() == 2);
    }
}

public static String XmlPullTag(XmlPullParser xpp, String tag) 
    throws XmlPullParserException, IOException {
    xpp.require(XmlPullParser.START_TAG, null, tag);
    String itemText = xpp.nextText();
    if (xpp.getEventType() != XmlPullParser.END_TAG) {
        xpp.nextTag();
    }
    xpp.require(XmlPullParser.END_TAG, null, tag);
    return itemText;
}

public static String XmlPullAttribute(XmlPullParser xpp, 
    String tag, String namespace, String name)
throws XmlPullParserException, IOException {
    assert (!TextUtils.isEmpty(tag));
    assert (!TextUtils.isEmpty(name));
    xpp.require(XmlPullParser.START_TAG, null, tag);
    String itemText = xpp.getAttributeValue(namespace, name);
    if (xpp.getEventType() != XmlPullParser.END_TAG) {
        xpp.nextTag();
    }
    xpp.require(XmlPullParser.END_TAG, null, tag);
    return itemText;
}