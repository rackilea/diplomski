StringBuffer sb = new StringBuffer(/*some appropriate size*/);
for (DomNode n : element.getChildNodes()) {
    if (n.getNodeType() == Node.TEXT_NODE) {
        sb.append(n.getTextContent());
    }
}
String text = sb.toString();