DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
// enable namespace processing
dbf.setNamespaceAware(true);
DocumentBuilder db = dbf.newDocumentBuilder();
Document document = db.parse(new File("J:/Desktop/Current.gpx"));

NodeList trkpts = document.getElementsByTagNameNS(
           "http://www.topografix.com/GPX/1/1", "trkpt");
for(int i = 0; i < trkpts.getLength(); i++) {
  Element pt = (Element)trkpts.item(i);
  // since namespaces are enabled we must use the DOM level 2 getAttributeNS,
  // not the legacy getAttribute, even though the attributes we're getting
  // do not themselves belong to a namespace.
  System.out.println("lat: " + pt.getAttributeNS(null, "lat") +
      ", long: " + pt.getAttributeNS(null, "lon"));
}