class LinkedHashSortedMapthing implements SortedSet {
    private class Foo extends LinkedHashMap {
        ...
    }

    private Foo foo;

    public void clear() {foo.clear();}
    public boolean containsValue(Object value) {return foo.containsValue(value);}
    ...
}