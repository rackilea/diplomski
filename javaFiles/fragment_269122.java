public void rotateRight() {
    if (!iterator.hasNext())
        iterator = cardinal.listIterator();
    this.heading = iterator.next();
}

public void rotateLeft() {
    if (!iterator.hasPrevious())
        iterator = cardinal.listIterator(cardinal.size());
    this.heading = iterator.previous();
}