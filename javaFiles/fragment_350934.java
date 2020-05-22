String day, hour, minute, second, background;
boolean status;

int resId = getResources().getIdentifier("xml/" + RememberMeServer, 
            "string", getActivity().getPackageName());
XmlPullParser xpp0 = getResources().getXml(resId);
XMLData xml = new XMLData(xpp0);
day = (xml.getValue("day"));
hour= (xml.getValue("hour"));
second= (xml.getValue("second"));
minute= (xml.getValue("minute"));
background= (xml.getValue("Graphic_6_7_Red"));
status= (xml.checkFieldPresence("Online"));