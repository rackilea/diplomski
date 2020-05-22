XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
         factory.setNamespaceAware(false);
         Context context = getApplicationContext();
         Resources res = context.getResources();
         XmlResourceParser xpp = res.getXml(R.xml.thedata);
         Map<int,ArrayList<string>> cv = new HashMap<int,ArrayList<string>>();

         //Helper stuff
         int curid = 0;
         ArrayList<String> temp = new ArrayList<String>();

         int eventType = xpp.getEventType();
         while (eventType != XmlPullParser.END_DOCUMENT) {
             if (eventType == XmlPullParser.START_TAG) {
                 if(xpp.getName().equalsIgnoreCase("id")){
                     curid = Integer.parseInt(xpp.nextText());
                 } 
                 if(xpp.getName().equalsIgnoreCase("room") == false && xpp.getName().equalsIgnoreCase("id") == false && xpp.getName().equalsIgnoreCase("data") == false){
                     temp.add(xpp.getName() + "<>" + xpp.nextText());
                 }

             } 
             else if(eventType==XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("room")){
                 cv.put(curid,temp);
                 temp = new ArrayList<String>();
             }
             eventType = xpp.next(); //move to next element
             //Restart Loop
         }