private boolean insideElementContainingTextNode;
private StringBuilder textBuilder;

public void startElement(String uri, String localName, String qName, Attributes attrs) {
    if ("w:t".equals(qName)) { // or is it localName?
        insideElementContainingTextNode = true;
        textBuilder = new StringBuilder();
    }
}

public void characters(char[] ch, int start, int length) {
    if (insideElementContainingTextNode) {
        textBuilder.append(ch, start, length);
    }
}

public void endElement(String uri, String localName, String qName) {
    if ("w:t".equals(qName)) { // or is it localName?
        insideElementContainingTextNode = false;
        String theCompleteText = this.textBuilder.toString();
        this.textBuilder = null;
    }
}