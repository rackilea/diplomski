public class SimpleXmlPullApp
{

    public static void main (String args[])
            throws XmlPullParserException, IOException
    {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();

        xpp.setInput( new StringReader ( "<current func = \"123\" name=\"lllo\" add=\"pol\" />" ) );
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if(eventType == XmlPullParser.START_TAG) {
                for(int i=0; i<xpp.getAttributeCount(); i++) {
                    System.out.println("Attribute name: " + xpp.getAttributeName(i) + " - Attribute value: " + xpp.getAttributeValue(i));
                }
            }
            eventType = xpp.next();
        }
    }
}