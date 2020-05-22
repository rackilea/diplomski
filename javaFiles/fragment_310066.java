Resources resources = getResources();
XmlResourceParser xmlParser = resources.getXml(R.xml.programlist);

...

int resourceId = xmlParser.getAttributeResourceValue(null, "color", 0);
pi.color = (resorceId == 0) ? SOME_DEFAULT_COLOR : resources.getColor(resourceId);
pi.pref = xmlParser.getAttributeResourceValue(null, "prefLayoutId", 0);