String titleText=null;

NodeList titles = doc.getElementsByTagName("title");

for (int i = 0; titleText == null && i < titles.getLength(); i++) {
    try {
        titleText = doc.item(i).getFirstChild().getNodeValue();
    } catch (SomeException e) {
    }  
}