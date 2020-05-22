NodeList nl = doc.getElementsByTagName("ErrorDetail").item(0).getChildNodes();
DOMSource source = null;
for (int x = 0; x < nl.getLength(); x++) {
   Node e = nl.item(x);
   if (e instanceof Element) {
     source = new DOMSource(e);
     transformer.transform(source, result);
   }
}