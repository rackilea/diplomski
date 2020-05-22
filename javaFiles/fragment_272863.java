public void readElement(Element element) {
    this.bar1 = wrap(element.getChild("bar1"), Bar::new);
    this.bar2 = wrap(element.getChild("bar1"), Bar::new);
    this.bar3 = wrap(element.getChild("bar1"), Bar::new);
}

protected <T> T wrap(Element element, Function<Element, T> elem) {
    if (element == null) {
        return null; // Not a good value
    }
    return elem.apply(element);
}