public boolean removeAll(Collection<?> c) {
    boolean modified = false;
    Iterator<?> e = iterator();
    while (e.hasNext()) {
        if (c.contains(e.next())) {
            e.remove();
            modified = true;
        }
    }
    return modified;
}