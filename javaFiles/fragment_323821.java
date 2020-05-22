public Element getCurrentElement(int offset) {
    ElementIterator ei = new ElementIterator(this);
    Element elem, currentElem = null;
    int elemLength = Integer.MAX_VALUE;

    while ((elem = ei.next()) != null) { //looking for closest element
        int start = elem.getStartOffset(), end = elem.getEndOffset(), len = end - start;
        if (elem.isLeaf() || elem.getName().equals("html"))
            continue;
        if (start <= offset && offset < end && len <= elemLength) {
            currentElem = elem;
            elemLength = len;
        }
    }

    return currentElem;
}