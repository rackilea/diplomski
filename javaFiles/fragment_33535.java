public void addFirst(T ele) {
    addAfter(ele, header);
}

public void addLast(T ele) {
    addAfter(ele, trailer.getPrev());
}