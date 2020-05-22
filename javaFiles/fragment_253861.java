List<Element> elements = new ArrayList<Element>();

while (subchilditr.hasNext()) {
    Element subchild = (Element) subchilditr.next();
    if (subchild.getText().equalsIgnoreCase(text)) {
        elements.add(subchild);
    }
}

for (Element element : elements) {
    element.getParent().removeContent(element);
}