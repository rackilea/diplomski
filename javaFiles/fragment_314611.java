public Stream filter(Predicate p) {
    this.filter = p; // just store it, don't apply it yet
    return this; // in reality: return a new stream
}
public List collect() {
    for (Object o : stream) {
        if (filter.test(o)) list.add(o);
    }
    return list;
}