public class parserPull
{

    private static final String ns = null;
    public parserPull(InputStream open) {
        try
        {
             XmlPullParser parser = Xml.newPullParser();
             parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
             parser.setInput(open, null);
             parser.nextTag();
             List<Entry> all = readFeed(parser);
             for(int i=0;i<all.size();i++)
             {
             Log.i("ID is..........",all.get(i).id);
             Log.i("Link is........",all.get(i).link);
             Log.i("Price is.......",all.get(i).price);
             }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private List<Entry> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
         List<Entry> entry = null;
        parser.require(XmlPullParser.START_TAG, ns, "prestashop");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            //Log.i("..................",name);
            // Starts by looking for the prestashop tag
            if (name.equals("products")) {
              entry= readProducts(parser);
            } else {
                skip(parser);
            }
        }  
        return entry;
    }
    private List<Entry> readProducts(XmlPullParser parser) throws XmlPullParserException, IOException {
        List<Entry> entries = new ArrayList<Entry>();

        parser.require(XmlPullParser.START_TAG, ns, "products");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
           // Log.i("..................",name);
            // Starts by looking for the products tag
            if (name.equals("product")) {
                entries.add(readEntry(parser));
            } else {
                skip(parser);
            }
        }  
        return entries;
    }
    private Entry readEntry(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "product");
        String title = null;
        String summary = null;
        String link = null;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
           // Log.i("...................",name);
            if (name.equals("id")) {
                title = readId(parser);
            } else if (name.equals("id_default_image")) {
                summary = readLink(parser);
            } else if (name.equals("price")) {
                link = readPrice(parser);
            } else {
                skip(parser);
            }
        }
        return new Entry(title, summary, link);
    }
    private String readPrice(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "price");
        String summary = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "price");
        return summary;
    }
    private String readLink(XmlPullParser parser) throws IOException, XmlPullParserException {
        String link = "";
        parser.require(XmlPullParser.START_TAG, ns, "id_default_image");
        String tag = parser.getName();
       // Log.i("............",tag);
        String relType = parser.getAttributeValue(null, "not_filterable");  
        if (tag.equals("id_default_image")) {
            if (relType.equals("true")){
                link = parser.getAttributeValue(null, "xlink:href");
                parser.nextTag();
            } 
        }
        parser.require(XmlPullParser.END_TAG, ns, "id_default_image");
        return link;
    }
    private String readId(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "id");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "id");
        return title;
    }
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }
    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
            case XmlPullParser.END_TAG:
                depth--;
                break;
            case XmlPullParser.START_TAG:
                depth++;
                break;
            }
        }
     }
    public static class Entry {
        public final String id;
        public final String link;
        public final String price;

        private Entry(String id, String link, String price) {
            this.id = id;
            this.link = link;
            this.price = price;
        }
    }
}