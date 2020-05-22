public String initiateParsing(Context context) {
    String result = "";
   FileInputStream fis = null;
    XmlPullParserFactory pullParserFactory;



    try {
        pullParserFactory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = pullParserFactory.newPullParser();

        // uses Context to getApplicationContext().getResources();
        Resources res = context.getApplicationContext().getResources();

        // Use direct Resource Tag with R
        InputStream in_st = res.openRawResource(R.raw.plant_catalog);
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        parser.setInput(in_st, null);

        parseXML(parser); // and so forth.....