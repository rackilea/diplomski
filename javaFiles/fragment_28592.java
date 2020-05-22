Element start = ...;
for (Element current : start) {
   // do something with current element
}

class Element implements Iterable<Element> {
    ...

    public Iterator<Element> iterator() {
        return new ElementIterator(this);
    }
}

class ElementIterator implements Iterator<Element> {
    private Element current;

    ElementIterator(Element start) {
        this.current = start;
    }

    public boolean hasNext() {
        return current != null;
    }

    public Element next() {
        Element result = current;
        current = current.next;
        return result;
    }
}