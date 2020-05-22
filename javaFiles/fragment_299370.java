class CountingHashSet extends HashSet {
    private int count = 0;
    boolean add(Object o) {
        count++;
        return super.add(o);
    }
    boolean addAll(Collection c) {
        count += c.size();
        return super.addAll(c);
    }
    int getCount() { return count; }
}