public boolean addAll(Collection<T> c) {
    boolean changed = false;
    for (T t:c) {
        changed |= this.add(t);
    } 
    return changed;
}