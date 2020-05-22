// this returns the root element, ie "GoldQuotes"
Element docEle = dom.getDocumentElement();

// get the list of Price elements children of the root
NodeList nl = docEle.getElementsByTagName("Price"); 

if ((nl != null) && (nl.getLength() > 0)) {
    for (int i = 0; i < nl.getLength(); i++) {
         // get the i-th Price element from the nodelist
         Element entry = (Element) nl.item(i);
         // get its Value attribute
         String priceValue = entry.getAttribute("Value");
         [....]
    }