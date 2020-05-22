@SuppressWarnings("unchecked")
private LinkedList<Foo> getList(int x, int y) {
    if (lists[y][x] == null) {
        lists[y][x] = new LinkedList<Foo>();
    }
    // Cast won't actually have any effect at execution time. It's
    // just to tell the compiler we know what we're doing.
    return (LinkedList<Foo>) lists[y][x];
}