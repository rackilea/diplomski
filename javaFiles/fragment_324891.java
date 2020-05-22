if(eventType == XmlPullParser.START_TAG) {
    soapResponse= xpp.getName().toString();
    String current = map.get(soapResponse);
    if (current != null && xpp.getText()!=null) {
        map.put( soapResponse, current += xpp.getText());
    }
    eventType = xpp.next();
}