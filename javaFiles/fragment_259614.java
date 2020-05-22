NamedNodeMap attribs = node.getAttributes();
if (attribs.getLength() > 0) {
    Node currencyAttrib = attribs.getNamedItem(CURRENCY);
    if (currencyAttrib != null) {
        String currencyTxt = currencyAttrib.getNodeValue();
        String rateTxt = attribs.getNamedItem(RATE).getNodeValue();
        // ...
    }
}