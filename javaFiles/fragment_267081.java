public boolean add(Object element) {
    if (isFull()) {
        remove();
    }
    return super.add(element);
}