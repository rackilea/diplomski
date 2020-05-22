NodeList elNodes = document.getElementsByTagName("el");
int size = elNodes.getLength();
for(int i = 0; i < size; i++) {
    Element el = (Element)elNodes.item(i);
    Element newEl = wrapWordsInContents(el, document);
    Element parent = (Element)el.getParentNode(); // this is `<root>`
    parent.replaceChild(newEl, el);
}