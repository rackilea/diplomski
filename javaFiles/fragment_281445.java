try {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser parser = factory.newPullParser();                     
        InputStream input = getResources().openRawResource(R.raw.test);
        parser.setInput(input, HTTP.UTF_8);     
        int eventType = parser.getEventType();
        while(eventType != XmlPullParser.END_DOCUMENT){             
            if(eventType == XmlPullParser.START_TAG){ 
                String prefix = parser.getPrefix();
                String name   = parser.getName();
                Log.i("XML", String.format("prefix=%s,name=%s",prefix,name));
                if( "dif".equals(prefix)){
                    handleDiff(parser);
                }else if ("res".equals(prefix)){
                    handleRes(parser);
                }
            }

            eventType = parser.next();
        }
    } catch (Exception e) {
        Log.e("XML","",e);
    }